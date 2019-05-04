package io.tminuszero;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.tminuszero.api.Launch;
import io.tminuszero.db.LaunchRepository;
import io.tminuszero.db.UpcomingLaunchEntity;


public class UpcomingLaunchesTabFragment extends Fragment {

    private ArrayList<UpcomingLaunchEntity> upcomingLaunchEntities;
    private RecyclerView mRecyclerView;
    private UpcomingLaunchesRVAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RequestQueue mQueue;
    private LaunchRepository launchRepository;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view_launches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recycler_view_launches);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        launchRepository = new LaunchRepository(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        upcomingLaunchEntities = new ArrayList<>();

        mQueue = Volley.newRequestQueue(getContext());
        parseJSON();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("DATABASE", "DELETING DATABASE");
        launchRepository.deleteAll();
    }
    private void parseJSON() {

        String url = "https://launchlibrary.net/1.4/launch/next/10";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    int itemCount = response.getInt("count");
                    Log.d("ITEMCOUNT", "" + itemCount);
                    JSONArray jsonArray = response.getJSONArray("launches");

                    for(int i = 0; i < itemCount; i++) {
                        UpcomingLaunchEntity entity = new UpcomingLaunchEntity();

                        JSONObject launch = jsonArray.getJSONObject(i);

                        JSONObject location = launch.getJSONObject("location");
                        JSONArray missions = launch.getJSONArray("missions");
                        JSONObject lsp = launch.getJSONObject("lsp");
                        JSONObject rocket = launch.getJSONObject("rocket");

                        JSONArray pads = location.getJSONArray("pads");
                        JSONObject pad = pads.getJSONObject(0);

                        // Launch attributes
                        entity.setLaunchID(launch.getInt("id"));
                        entity.setNet(launch.getString("net"));
                        entity.setRocketName(rocket.getString("name"));
                        entity.setProbability(launch.getInt("probability"));

                        entity.setLSPName(lsp.getString("name"));
                        entity.setLocationName(location.getString("name"));
                        entity.setPadName(pad.getString("name"));

                        // Check if Launch has a mission array
                        if(missions.length() > 0) {
                            JSONObject mission = missions.getJSONObject(0);

                            entity.setMissionName(mission.getString("name"));
                            entity.setMissionDetails(mission.getString("description"));

                            // Todo: Add mission type to database
                            //if(mission.getString("typeName") != null) missionType = mission.getString("typeName");

                            JSONArray agencies = mission.getJSONArray("agencies");
                            if(agencies.length() > 0) {
                                JSONObject agency = agencies.getJSONObject(0);
                                entity.setAgencyName(agency.getString("name"));
                            }

                        }

                        entity.setHashTag(launch.getString("hashtag"));

                        // -1 == Not valid, 1 == Green, 2 == Red, 3 == Success, 4 == Failed
                        entity.setFlightStatus(((launch.getInt("status") <= 0) || (launch.getInt("status") > 4)) ? -1 : launch.getInt("status"));
                        entity.setFlightHoldReason(launch.getString("holdreason"));
                        entity.setFlightFailReason(launch.getString("failreason"));

                        /*

                        // Mission attributes
                        JSONObject mission;
                        String missionName = "";
                        String missionDescription = "";
                        // Todo: Add mission type to database
                        String missionType = "";
                        String agencyName = "";

                        // Launch Service Provider (LSP) attributes
                        String lspName = (lsp.getString("name") == null) ? "" : lsp.getString("name");

                        // Rocket attributes
                        String rocketName = (rocket.getString("name") == null) ? "" : rocket.getString("name");
                        // Todo: Add to database
                        String rocketConfig = (rocket.getString("configuration") == null) ? "" : rocket.getString("configuration");
                        String rocketFamily = (rocket.getString("familyname") == null) ? "" : rocket.getString("familyname");

                        // Location attributes
                        String locationName = (location.getString("name") == null) ? "" : location.getString("name");

                        // Pad attributes
                        String padsName = (pad.getString("name") == null) ? "" : pad.getString("name");

                        String padsWikiURL = (pad.getString("wikiURL") == null) ? "" : pad.getString("wikiURL");
                        String padsMapURL = (pad.getString("mapURL") == null) ? "" : pad.getString("mapURL");
                        String padsLatitude = (pad.getString("latitude") == null) ? "" : pad.getString("latitude");
                        String padsLongitude = (pad.getString("longitude") == null) ? "" : pad.getString("longitude");
                        */

                        Log.d("DATABASE", "INSERTING DATABASE");

                        upcomingLaunchEntities.add(entity);
                        launchRepository.insertLaunch(entity);
                    }

                    mRecyclerViewAdapter = new UpcomingLaunchesRVAdapter(upcomingLaunchEntities);
                    mRecyclerView.setAdapter(mRecyclerViewAdapter);

                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

}
