package io.tminuszero;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.tminuszero.api.Launch;

public class PastLaunchesRVAdapter extends RecyclerView.Adapter<PastLaunchesRVAdapter.LaunchViewHolder> {

    private ArrayList<Launch> followedLaunchList;

    PastLaunchesRVAdapter(ArrayList<Launch> followedLaunchList){
        this.followedLaunchList = followedLaunchList;
    }

    @NonNull
    @Override
    public LaunchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.launches_items, viewGroup, false);
        return new LaunchViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(LaunchViewHolder launchViewHolder, int i) {
        Launch launch = followedLaunchList.get(i);

        // TODO: change color upon status
//        launchViewHolder.launchSequence.setText(String.valueOf(launch.getSequence()));
        launchViewHolder.launchVehicle.setText(launch.rocket.getName());
        launchViewHolder.missionName.setText(launch.mission.getName());
    }

    @Override
    public int getItemCount() {
        return  (followedLaunchList != null) ? followedLaunchList.size() : 0;
    }

    public static class LaunchViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView launchSequence;
        TextView launchServiceProvider;
        TextView launchVehicle;
        TextView missionName;

        public LaunchViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view_launches);

            // TODO: change color upon status
//            launchSequence = itemView.findViewById(R.id.launch_status);
            launchVehicle = itemView.findViewById(R.id.launch_vehicle);
            missionName = itemView.findViewById(R.id.mission_name);
        }

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
