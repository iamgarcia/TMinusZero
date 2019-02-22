package io.tminuszero;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FollowedLaunchesRVAdapter extends RecyclerView.Adapter<FollowedLaunchesRVAdapter.LaunchViewHolder> {

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

    List<Launch> followedLaunchList;

    FollowedLaunchesRVAdapter(List<Launch> followedLaunchList){
        this.followedLaunchList = followedLaunchList;
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
        launchViewHolder.launchSequence.setText(String.valueOf(followedLaunchList.get(i).launchSequence)); // Parse int as string in order to display
        launchViewHolder.launchServiceProvider.setText(followedLaunchList.get(i).launchServiceProvider);
        launchViewHolder.launchVehicle.setText(followedLaunchList.get(i).launchVehicle);
        launchViewHolder.missionName.setText(followedLaunchList.get(i).missionName);
    }

    @Override
    public int getItemCount() {
        return followedLaunchList.size();
    }

}
