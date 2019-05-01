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

    public LaunchesItemView(int rocketID, Context context) {
        this.rocketID = rocketID;
        launchRepository = new LaunchRepository(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LaunchEntity launchEntity = launchRepository.getLaunchEntity(rocketID);
        ((MainActivity) getActivity()).setTitle(launchEntity.getMissionName());

        View rootView = inflater.inflate(R.layout.fragment_launch_view, container, false);

        // Set rocket name
        final TextView rocketName = (TextView) rootView.findViewById(R.id.rocketName);
        rocketName.setText(launchEntity.getRocketName());

        // Set mission name
        final TextView missionName = (TextView) rootView.findViewById(R.id.missionName);
        missionName.setText(launchEntity.getMissionName());

        // TODO: Fix percentage display, on -1%
        // Set percentage display
        final TextView percentage = (TextView) rootView.findViewById(R.id.percentage);
        percentage.setText(launchEntity.getProbability() + "%");

        // TODO: Fix Date to show local time?
        // Set No Earlier Than (NET)
        final TextView net = (TextView) rootView.findViewById(R.id.net);
        net.setText(launchEntity.getNet());

        // Set Launch Service Provider (LSP)
        final TextView lsp = (TextView) rootView.findViewById(R.id.lsp);
        lsp.setText(launchEntity.getLSPName());

        // Set location
        final TextView location = (TextView) rootView.findViewById(R.id.location);
        location.setText(launchEntity.getLocationName());

        // Set agency name
        final TextView agencyName = (TextView) rootView.findViewById(R.id.agency);
        agencyName.setText(launchEntity.getAgencyName());

        // Set pad name
        final TextView padName = (TextView) rootView.findViewById(R.id.pad);
        padName.setText(launchEntity.getPadName());

        // Set mission details
        final TextView missionDetails = (TextView) rootView.findViewById(R.id.missionInfo);
        missionDetails.setText(launchEntity.getMissionDetails());

        return rootView;
    }



}
