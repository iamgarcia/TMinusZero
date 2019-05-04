package io.tminuszero;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.tminuszero.db.UpcomingLaunchEntity;
import io.tminuszero.db.LaunchRepository;

public class LaunchesItemView extends Fragment {
    LaunchRepository launchRepository;

    private int rocketID;

    public LaunchesItemView() {
        // Empty constructor
    }

    public LaunchesItemView(int rocketID, Context context) {
        this.rocketID = rocketID;
        launchRepository = new LaunchRepository(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        UpcomingLaunchEntity upcomingLaunchEntity = launchRepository.getLaunchEntity(rocketID);

        // Set hashtag
        if(upcomingLaunchEntity.getHashTag().equals("null"))
            ((MainActivity) getActivity()).setTitle("Hashtag TBD");
        else
            ((MainActivity) getActivity()).setTitle(upcomingLaunchEntity.getHashTag());

        View rootView = inflater.inflate(R.layout.fragment_launch_view, container, false);

        // Set rocket name
        final TextView rocketName = (TextView) rootView.findViewById(R.id.rocketName);
        rocketName.setText(upcomingLaunchEntity.getRocketName());

        // Set mission name
        final TextView missionName = (TextView) rootView.findViewById(R.id.missionName);
        missionName.setText(upcomingLaunchEntity.getMissionName());

        // Set percentage display
        final TextView percentage = (TextView) rootView.findViewById(R.id.percentage);
        if((upcomingLaunchEntity.getProbability() < 0) || (upcomingLaunchEntity.getProbability() > 100))
            percentage.setText("Unknown");
        else
            percentage.setText(upcomingLaunchEntity.getProbability() + "%");

        // TODO: Fix Date to show local time?
        // Set No Earlier Than (NET)
        final TextView net = (TextView) rootView.findViewById(R.id.net);
        if(upcomingLaunchEntity.getNet().isEmpty())
            net.setText("Launch date not yet known");
        else
            net.setText(upcomingLaunchEntity.getNet());

        // Set Launch Service Provider (LSP)
        final TextView lsp = (TextView) rootView.findViewById(R.id.lsp);
        if(upcomingLaunchEntity.getLSPName().isEmpty())
            lsp.setText("Launch service provider not yet known");
        else
            lsp.setText(upcomingLaunchEntity.getLSPName());

        // Set location
        final TextView location = (TextView) rootView.findViewById(R.id.location);
        if(upcomingLaunchEntity.getLocationName().isEmpty())
            location.setText("Location not yet known");
        else
            location.setText(upcomingLaunchEntity.getLocationName());

        // Set agency name
        final TextView agencyName = (TextView) rootView.findViewById(R.id.agency);
        if(upcomingLaunchEntity.getAgencyName().isEmpty())
            agencyName.setText("Agency not yet known");
        else
            agencyName.setText(upcomingLaunchEntity.getAgencyName());

        // Set pad name
        final TextView padName = (TextView) rootView.findViewById(R.id.pad);
        padName.setText(upcomingLaunchEntity.getPadName());

        // Set mission details
        final TextView missionDetails = (TextView) rootView.findViewById(R.id.missionInfo);
        if(upcomingLaunchEntity.getMissionDetails().isEmpty())
            missionDetails.setText("Mission details not yet known");
        else
            missionDetails.setText(upcomingLaunchEntity.getMissionDetails());

        return rootView;
    }



}
