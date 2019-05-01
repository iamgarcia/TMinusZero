package io.tminuszero;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import io.tminuszero.db.LaunchEntity;
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
        LaunchEntity launchEntity = launchRepository.getLaunchEntity(rocketID);

        // Set hashtag
        if(launchEntity.getMissionName().isEmpty())
            ((MainActivity) getActivity()).setTitle("Hashtag TBD");
        else
            ((MainActivity) getActivity()).setTitle(launchEntity.getMissionName());

        View rootView = inflater.inflate(R.layout.fragment_launch_view, container, false);

        // Set rocket name
        final TextView rocketName = (TextView) rootView.findViewById(R.id.rocketName);
        rocketName.setText(launchEntity.getRocketName());

        // Set mission name
        final TextView missionName = (TextView) rootView.findViewById(R.id.missionName);
        missionName.setText(launchEntity.getMissionName());

        // Set percentage display
        final TextView percentage = (TextView) rootView.findViewById(R.id.percentage);
        if((launchEntity.getProbability() < 0) || (launchEntity.getProbability() > 100))
            percentage.setText("Unknown");
        else
            percentage.setText(launchEntity.getProbability() + "%");

        // TODO: Fix Date to show local time?
        // Set No Earlier Than (NET)
        final TextView net = (TextView) rootView.findViewById(R.id.net);
        if(launchEntity.getNet().isEmpty())
            net.setText("Launch date not yet known");
        else
            net.setText(launchEntity.getNet());

        // Set Launch Service Provider (LSP)
        final TextView lsp = (TextView) rootView.findViewById(R.id.lsp);
        if(launchEntity.getLSPName().isEmpty())
            lsp.setText("Launch service provider not yet known");
        else
            lsp.setText(launchEntity.getLSPName());

        // Set location
        final TextView location = (TextView) rootView.findViewById(R.id.location);
        if(launchEntity.getLocationName().isEmpty())
            location.setText("Location not yet known");
        else
            location.setText(launchEntity.getLocationName());

        // Set agency name
        final TextView agencyName = (TextView) rootView.findViewById(R.id.agency);
        if(launchEntity.getAgencyName().isEmpty())
            agencyName.setText("Agency not yet known");
        else
            agencyName.setText(launchEntity.getAgencyName());

        // Set pad name
        final TextView padName = (TextView) rootView.findViewById(R.id.pad);
        padName.setText(launchEntity.getPadName());

        // Set mission details
        final TextView missionDetails = (TextView) rootView.findViewById(R.id.missionInfo);
        if(launchEntity.getMissionDetails().isEmpty())
            missionDetails.setText("Mission details not yet known");
        else
            missionDetails.setText(launchEntity.getMissionDetails());

        return rootView;
    }



}
