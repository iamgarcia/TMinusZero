package io.tminuszero;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import io.tminuszero.db.DataBaseContract;
import io.tminuszero.db.DataBaseHelper;

import static android.content.ContentValues.TAG;

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
                    JSONArray jsonArray = response.getJSONArray("launches");

                    // Initiate Database & Open in W
                    DataBaseHelper dbHelper = new DataBaseHelper(getContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    for(int i = 0; i < itemCount; i++) {
                        upcomingLaunchList.add(new Launch());

                        JSONObject launch = jsonArray.getJSONObject(i);

                        JSONObject location = launch.getJSONObject("location");
                        JSONArray missions = launch.getJSONArray("missions");
                        JSONObject lsp = launch.getJSONObject("lsp");
                        JSONObject rocket = launch.getJSONObject("rocket");

                        JSONArray imageSizes = rocket.getJSONArray("imageSizes");
                        JSONArray pads = location.getJSONArray("pads");
                        JSONObject pad = pads.getJSONObject(0);

                        // Mission attributes
                        JSONObject mission;
                        String missionName = "";
                        String missionDescription = "";
                        String missionType = "";
                        if(missions.length() > 0) {
                            mission = missions.getJSONObject(0);

                            missionName = (mission.getString("name") == null) ? "" : mission.getString("name");
                            missionDescription = (mission.getString("description") == null) ? "" : mission.getString("description");
                            missionType = (mission.getString("typeName") == null) ? "" : mission.getString("typeName");
                        }

                        // LSP attributes
                        String lspName;
                        String lspNameAbbrev;
                        String lspCountryCode;
                        String lspWikiURL;

                        lspName = (lsp.getString("name") == null) ? "" : lsp.getString("name");
                        lspNameAbbrev = (lsp.getString("abbrev") == null) ? "" : lsp.getString("abbrev");
                        lspCountryCode = (lsp.getString("countryCode") == null) ? "" : lsp.getString("countryCode");
                        lspWikiURL = (lsp.getString("wikiURL") == null) ? "" : lsp.getString("wikiURL");

                        // Rocket attributes
                        String rocketName;
                        String rocketConfig;
                        String rocketFamily;
                        String rocketWikiURL;
                        String rocketImageURL;

                        rocketName = (rocket.getString("name") == null) ? "" : rocket.getString("name");
                        rocketConfig = (rocket.getString("configuration") == null) ? "" : rocket.getString("configuration");
                        rocketFamily = (rocket.getString("familyname") == null) ? "" : rocket.getString("familyname");
                        rocketWikiURL = (rocket.getString("wikiURL") == null) ? "" : rocket.getString("wikiURL");;
                        rocketImageURL = (rocket.getString("imageURL") == null) ? "" : rocket.getString("imageURL");

                        ArrayList<Integer> rocketImageSizes = new ArrayList<>();

                        if(imageSizes.length() == 0) {
                            Log.d("Critical", "imageSizes array is empty");
                        } else {
                            for(int j = 0; j < imageSizes.length(); j++) {
                                rocketImageSizes.add(imageSizes.getInt(j));
                            }
                        }

                        // Location attributes
                        String locationName;
                        String locationCountryCode;

                        String padsName;
                        String padsWikiURL;
                        String padsMapURL;
                        String padsLatitude;
                        String padsLongitude;

                        locationName = (location.getString("name") == null) ? "" : location.getString("name");
                        locationCountryCode = (location.getString("countryCode") == null) ? "" : location.getString("countryCode");
                        padsName = (pad.getString("name") == null) ? "" : pad.getString("name");
                        padsWikiURL = (pad.getString("wikiURL") == null) ? "" : pad.getString("wikiURL");
                        padsMapURL = (pad.getString("mapURL") == null) ? "" : pad.getString("mapURL");
                        padsLatitude = (pad.getString("latitude") == null) ? "" : pad.getString("latitude");
                        padsLongitude = (pad.getString("longitude") == null) ? "" : pad.getString("longitude");

                        upcomingLaunchList.get(i).configLSP(lspName, lspNameAbbrev, lspCountryCode, lspWikiURL);
                        upcomingLaunchList.get(i).configMission(missionName, missionDescription, missionType);
                        upcomingLaunchList.get(i).configRocket(rocketName, rocketConfig, rocketFamily, rocketWikiURL, rocketImageURL, rocketImageSizes);
                        upcomingLaunchList.get(i).configLocation(locationName, locationCountryCode, padsName, padsWikiURL, padsMapURL, padsLatitude, padsLongitude);

                        // TODO: Make a global variable class so I can store data to it and that use across the app.
                        ContentValues val = new ContentValues();

                        val.put(DataBaseContract.DBEntry.COLUMN_NAME_LAUNCH, missionName);
                        val.put(DataBaseContract.DBEntry.COLUMN_NET_LAUNCH, missionType);

                        long newRowID = db.insert(DataBaseContract.DBEntry.TABLE_NAME, null, val);
                        if(newRowID == -1) {
                            Log.d("DATABASE", "COULD NOT CREATE ROW");
                        }
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
