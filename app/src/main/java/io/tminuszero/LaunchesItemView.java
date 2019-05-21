package io.tminuszero;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        // Set background to the rocket
        ImageView rocketImage = rootView.findViewById(R.id.rocketImage);
        Picasso.get()
                .load(upcomingLaunchEntity.getRocketImageURL())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fit()
                .centerCrop(Gravity.TOP)
                .noFade()
                .into(rocketImage);

        // Set rocket name
        final TextView rocketName = rootView.findViewById(R.id.rocketName);
        rocketName.setText(upcomingLaunchEntity.getRocketName());

        // Set mission name
        final TextView missionName = rootView.findViewById(R.id.missionName);
        missionName.setText(upcomingLaunchEntity.getMissionName());

        // Set percentage display
        final TextView percentage = rootView.findViewById(R.id.percentage);
        if((upcomingLaunchEntity.getProbability() < 0) || (upcomingLaunchEntity.getProbability() > 100))
            percentage.setText("Unknown");
        else
            percentage.setText(upcomingLaunchEntity.getProbability() + "%");

        // TODO: Fix Date to show local time?
        // Set No Earlier Than (NET)
        final TextView net = rootView.findViewById(R.id.net);
        if(upcomingLaunchEntity.getNet().isEmpty())
            net.setText("Launch date not yet known");
        else
            net.setText(upcomingLaunchEntity.getNet());

        // Set Launch Service Provider (LSP)
        final TextView lsp = rootView.findViewById(R.id.lsp);
        if(upcomingLaunchEntity.getLSPName().isEmpty())
            lsp.setText("Launch service provider not yet known");
        else
            lsp.setText(upcomingLaunchEntity.getLSPName());

        // Set location
        final TextView location = rootView.findViewById(R.id.location);
        if(upcomingLaunchEntity.getLocationName().isEmpty())
            location.setText("Location not yet known");
        else
            location.setText(upcomingLaunchEntity.getLocationName());

        // Set agency name
        final TextView agencyName = rootView.findViewById(R.id.agency);
        if(upcomingLaunchEntity.getAgencyName().isEmpty())
            agencyName.setText("Agency not yet known");
        else
            agencyName.setText(upcomingLaunchEntity.getAgencyName());

        // Set pad name
        final TextView padName = rootView.findViewById(R.id.pad);
        padName.setText(upcomingLaunchEntity.getPadName());

        // Set mission details
        final TextView missionDetails = rootView.findViewById(R.id.missionInfo);
        if(upcomingLaunchEntity.getMissionDetails().isEmpty())
            missionDetails.setText("Mission details not yet known");
        else
            missionDetails.setText(upcomingLaunchEntity.getMissionDetails());

        return rootView;
    }



}
