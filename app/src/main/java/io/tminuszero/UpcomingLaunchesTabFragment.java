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


public class UpcomingLaunchesTabFragment extends Fragment {

    private ArrayList<Launch> upcomingLaunchList;
    private RecyclerView mRecyclerView;
    private UpcomingLaunchesRVAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RequestQueue mQueue;

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
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        upcomingLaunchList = new ArrayList<>();

        mQueue = Volley.newRequestQueue(getContext());
        parseJSON();
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
                        upcomingLaunchList.add(new Launch());
                        Log.d("TEST", "" + i);

                        JSONObject launch = jsonArray.getJSONObject(i);

                        JSONObject location = launch.getJSONObject("location");
                        JSONArray missions = launch.getJSONArray("missions");
                        JSONObject lsp = launch.getJSONObject("lsp");
                        JSONObject rocket = launch.getJSONObject("rocket");

                        JSONArray imageSizes = rocket.getJSONArray("imageSizes");
                        JSONArray pads = location.getJSONArray("pads");
                        JSONObject pad = pads.getJSONObject(0);

                        // Launch attributes
                        String launchName = launch.getString("name");
                        int launchID = launch.getInt("id");
                        String launchNet = launch.getString("net");
                        int launchTBDTime = launch.getInt("tbdtime");
                        int launchTBDDate = launch.getInt("tbddate");
                        int launchProbability = launch.getInt("probability");

                        // FlightStatus Attributes
                        int flightStatus = ((launch.getInt("status") <= 0) || (launch.getInt("status") > 4)) ? -1 : launch.getInt("status"); // -1 == Not valid, 1 == Green, 2 == Red, 3 == Success, 4 == Failed
                        String flightHoldReason = (launch.getString("holdreason") == null) ? "" : launch.getString("holdreason");
                        String flightFailReason = (launch.getString("failreason") == null) ? "" : launch.getString("failreason");

                        // Mission attributes
                        JSONObject mission;
                        String missionName = "";
                        String missionDescription = "";
                        String missionType = "";
                        String agencyName = "";
                        if(missions.length() > 0) {
                            mission = missions.getJSONObject(0);

                            if(mission.getString("name") != null) missionName = mission.getString("name");
                            if(mission.getString("description") != null) missionDescription = mission.getString("description");
                            if(mission.getString("typeName") != null) missionType = mission.getString("typeName");

                            // TODO: The docs says agencies should return an array however in this
                            //       request, it returns a null object, not an array
                            JSONArray agencies = mission.getJSONArray("agencies");
                            JSONObject agency = agencies.getJSONObject(0);
                            agencyName = agency.getString("name");
                        }

                        // Launch Service Provider (LSP) attributes
                        String lspName = (lsp.getString("name") == null) ? "" : lsp.getString("name");
                        String lspNameAbbrev = (lsp.getString("abbrev") == null) ? "" : lsp.getString("abbrev");
                        String lspCountryCode = (lsp.getString("countryCode") == null) ? "" : lsp.getString("countryCode");
                        String lspWikiURL = (lsp.getString("wikiURL") == null) ? "" : lsp.getString("wikiURL");

                        // Rocket attributes
                        String rocketName = (rocket.getString("name") == null) ? "" : rocket.getString("name");
                        String rocketConfig = (rocket.getString("configuration") == null) ? "" : rocket.getString("configuration");
                        String rocketFamily = (rocket.getString("familyname") == null) ? "" : rocket.getString("familyname");
                        String rocketWikiURL = (rocket.getString("wikiURL") == null) ? "" : rocket.getString("wikiURL");;
                        String rocketImageURL = (rocket.getString("imageURL") == null) ? "" : rocket.getString("imageURL");

                        ArrayList<Integer> rocketImageSizes = new ArrayList<>();

                        if(imageSizes.length() == 0) {
                            Log.d("Critical", "imageSizes array is empty");
                        } else {
                            for(int j = 0; j < imageSizes.length(); j++) {
                                rocketImageSizes.add(imageSizes.getInt(j));
                            }
                        }

                        // Location attributes
                        String locationName = (location.getString("name") == null) ? "" : location.getString("name");
                        String locationCountryCode = (location.getString("countryCode") == null) ? "" : location.getString("countryCode");

                        // Pad attributes
                        String padsName = (pad.getString("name") == null) ? "" : pad.getString("name");
                        String padsWikiURL = (pad.getString("wikiURL") == null) ? "" : pad.getString("wikiURL");
                        String padsMapURL = (pad.getString("mapURL") == null) ? "" : pad.getString("mapURL");
                        String padsLatitude = (pad.getString("latitude") == null) ? "" : pad.getString("latitude");
                        String padsLongitude = (pad.getString("longitude") == null) ? "" : pad.getString("longitude");

                        // Configure the launch object at index i
                        upcomingLaunchList.get(i).configLaunch(launchName, launchNet, launchTBDTime, launchTBDDate, launchProbability);
                        upcomingLaunchList.get(i).configLSP(lspName, lspNameAbbrev, lspCountryCode, lspWikiURL);
                        upcomingLaunchList.get(i).configMission(missionName, missionDescription, missionType);
                        upcomingLaunchList.get(i).configRocket(rocketName, rocketConfig, rocketFamily, rocketWikiURL, rocketImageURL, rocketImageSizes);
                        upcomingLaunchList.get(i).configLocation(locationName, locationCountryCode, padsName, padsWikiURL, padsMapURL, padsLatitude, padsLongitude);

                        LaunchRepository launchRepository = new LaunchRepository(getContext());
                        Log.d("DATABASE", "INSERTING DATABASE");

                        launchRepository.insertLaunch(launchID, launchNet, rocketName,
                                missionName, launchProbability, lspName,
                                locationName, padsName, agencyName, missionDescription);
                    }

                    mRecyclerViewAdapter = new UpcomingLaunchesRVAdapter(upcomingLaunchList);
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
