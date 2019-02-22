package io.tminuszero;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UpcomingLaunchesRVAdapter extends RecyclerView.Adapter<UpcomingLaunchesRVAdapter.LaunchViewHolder> {

    public static class LaunchViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView launchSequence;
        TextView launchServiceProvider;
        TextView launchVehicle;
        TextView missionName;

        LaunchViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view_launches);
            launchSequence = itemView.findViewById(R.id.launch_sequence);
            launchServiceProvider = itemView.findViewById(R.id.launch_service_provider);
            launchVehicle = itemView.findViewById(R.id.launch_vehicle);
            missionName = itemView.findViewById(R.id.mission_name);
        }

    }

    List<Launch> upcomingLaunchList;

    UpcomingLaunchesRVAdapter(List<Launch> upcomingLaunchList){
        this.upcomingLaunchList = upcomingLaunchList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public LaunchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.launches_items, viewGroup, false);
        LaunchViewHolder mLaunchViewHolder = new LaunchViewHolder(mView);
        return mLaunchViewHolder;
    }

    @Override
    public void onBindViewHolder(LaunchViewHolder launchViewHolder, int i) {
        launchViewHolder.launchSequence.setText(String.valueOf(upcomingLaunchList.get(i).launchSequence)); // Parse int as string in order to display
        launchViewHolder.launchServiceProvider.setText(upcomingLaunchList.get(i).launchServiceProvider);
        launchViewHolder.launchVehicle.setText(upcomingLaunchList.get(i).launchVehicle);
        launchViewHolder.missionName.setText(upcomingLaunchList.get(i).missionName);
    }

    @Override
    public int getItemCount() {
        return upcomingLaunchList.size();
    }

}
