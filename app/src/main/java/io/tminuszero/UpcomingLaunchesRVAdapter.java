package io.tminuszero;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        launchViewHolder.launchSequence.setText(String.valueOf(launch.getSequence()));
//        launchViewHolder.launchServiceProvider.setText(launch.lsp.getName());
        launchViewHolder.launchVehicle.setText(launch.rocket.getName());
        launchViewHolder.missionName.setText(launch.mission.getName());
    }

    @Override
    public int getItemCount() {
        return  (upcomingLaunchList != null) ? upcomingLaunchList.size() : 0;
    }

    public static class LaunchViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView launchSequence;
        TextView launchVehicle;
        TextView missionName;

        public LaunchViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view_launches);
            launchSequence = itemView.findViewById(R.id.launch_sequence);
            launchVehicle = itemView.findViewById(R.id.launch_vehicle);
            missionName = itemView.findViewById(R.id.mission_name);
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
