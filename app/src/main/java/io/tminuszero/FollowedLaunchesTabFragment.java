package io.tminuszero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FollowedLaunchesTabFragment extends Fragment {

    TextView launchSequence;
    TextView launchServiceProvider;
    TextView launchVehicle;
    TextView missionName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_followed_launches, container, false);

        launchSequence = view.findViewById(R.id.launch_sequence);
        launchServiceProvider = view.findViewById(R.id.launch_service_provider);
        launchVehicle = view.findViewById(R.id.launch_vehicle);
        missionName = view.findViewById(R.id.mission_name);

        launchSequence.setText(String.valueOf(1));
        launchServiceProvider.setText("SpaceX");
        launchVehicle.setText("Falcon 9");
        missionName.setText("CRS-16");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
