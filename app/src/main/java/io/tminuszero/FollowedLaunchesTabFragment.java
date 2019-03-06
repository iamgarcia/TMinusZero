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

import java.util.ArrayList;
import java.util.List;

public class FollowedLaunchesTabFragment extends Fragment {

    private List<Launch> followedLaunchList;
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

//        initializeData();
        initializeAdapter();
    }

//    private void initializeData() {
//        followedLaunchList = new ArrayList<>();
//
//        // Add a for loop that sets the attributes for each item in the Launch array.
//
//        followedLaunchList.add(new Launch(1, "SpaceX", "Falcon 9 Block 5", "Nusantara Satu & GTO-1 "));
//        followedLaunchList.add(new Launch(2, "Rocket Lab", "Electron", "DARPA R3D2"));
//        followedLaunchList.add(new Launch(3, "SpaceX", "Falcon 9 Block 5", "SpX-DM1 "));
//        followedLaunchList.add(new Launch(4, "SpaceX", "Falcon 9 Block 5", "RADARSAT Constellation"));
//        followedLaunchList.add(new Launch(5, "SpaceX", "Falcon Heavy", "Arabsat-6A"));
//    }

    private void initializeAdapter() {
        mRecyclerViewAdapter = new FollowedLaunchesRVAdapter(followedLaunchList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

}
