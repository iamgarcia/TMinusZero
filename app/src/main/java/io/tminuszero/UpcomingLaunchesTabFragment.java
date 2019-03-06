package io.tminuszero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;

public class UpcomingLaunchesTabFragment extends Fragment {

    private List<Launch> upcomingLaunchList;
    private RecyclerView mRecyclerView;
    private FollowedLaunchesRVAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;

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

        RequestQueue mQueue = Volley.newRequestQueue(getContext());

        jsonParse();
//        initializeData();
        initializeAdapter();
    }

//    private void initializeData() {
//        upcomingLaunchList = new ArrayList<>();
//        upcomingLaunchList.add(new Launch(1, "Russia", "Soyuz 2.1b/Fregat-M", "EgyptSat-A"));
//        upcomingLaunchList.add(new Launch(2, "SpaceX", "Falcon 9 Block 5", "Nusantara Satu & GTO-1 "));
//        upcomingLaunchList.add(new Launch(3, "Russia", "Soyuz STB/Fregat", "OneWeb F6"));
//        upcomingLaunchList.add(new Launch(4, "Rocket Lab", "Electron", "DARPA R3D2"));
//        upcomingLaunchList.add(new Launch(5, "Russia", "Soyuz 2.1a/Fregat", "Meridian-M 18"));
//        upcomingLaunchList.add(new Launch(6, "SpaceX", "Falcon 9 Block 5", "SpX-DM1 "));
//        upcomingLaunchList.add(new Launch(7, "SpaceX", "Falcon 9 Block 5", "RADARSAT Constellation"));
//        upcomingLaunchList.add(new Launch(8, "SpaceX", "Falcon Heavy", "Arabsat-6A"));
//    }

    private void initializeAdapter() {
        mRecyclerViewAdapter = new FollowedLaunchesRVAdapter(upcomingLaunchList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void jsonParse() {
        String url = "https://launchlibrary.net/1.4/launch/next/15";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("launches");

                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject launch = jsonArray.getJSONObject(i);

                        upcomingLaunchList = new ArrayList<>();
                        upcomingLaunchList.add(new Launch());
                        upcomingLaunchList.get(i).getSequence();
                    }
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
    }

}
