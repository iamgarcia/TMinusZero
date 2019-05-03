package io.tminuszero;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.tminuszero.api.Launch;

public class UpcomingLaunchesRVAdapter extends RecyclerView.Adapter<UpcomingLaunchesRVAdapter.LaunchViewHolder> {

    private ArrayList<Launch> upcomingLaunchList;

    UpcomingLaunchesRVAdapter(ArrayList<Launch> upcomingLaunchList){
        this.upcomingLaunchList = upcomingLaunchList;
    }

    @NonNull
    @Override
    public LaunchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.launches_items, viewGroup, false);
        return new LaunchViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(LaunchViewHolder launchViewHolder, int i) {
        Launch launch = upcomingLaunchList.get(i);

        int green = Color.parseColor("#4CAF50");
        int red = Color.parseColor("#FF0000");
        if(launch.flightStatus.getStatus() == 1) launchViewHolder.launchStatus.setColorFilter(green);
        if(launch.flightStatus.getStatus() == 2) launchViewHolder.launchStatus.setColorFilter(red);

        launchViewHolder.launchVehicle.setText(launch.rocket.getName());
        launchViewHolder.missionName.setText(launch.mission.getName());

        // TODO: Find a better way to do this.
        launchViewHolder.rocketID = launch.getLaunchID();
    }

    @Override
    public int getItemCount() {
        return  (upcomingLaunchList != null) ? upcomingLaunchList.size() : 0;
    }

    public static class LaunchViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        ImageView launchStatus;
        TextView launchVehicle;
        TextView missionName;
        int rocketID;

        public LaunchViewHolder(final View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view_launches);
            launchStatus = itemView.findViewById(R.id.launch_status);
            launchVehicle = itemView.findViewById(R.id.launch_vehicle);
            missionName = itemView.findViewById(R.id.mission_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    Fragment fragment = new LaunchesItemView(rocketID, v.getContext());
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
