package io.tminuszero;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.LaunchViewHolder> {

    public static class LaunchViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView launchSequence;
        TextView launchServiceProvider;
        TextView launchVehicle;
        TextView missionName;

        LaunchViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            launchSequence = itemView.findViewById(R.id.launch_sequence);
            launchServiceProvider = itemView.findViewById(R.id.launch_service_provider);
            launchVehicle = itemView.findViewById(R.id.launch_vehicle);
            missionName = itemView.findViewById(R.id.mission_name);
        }

    }

    List<Launch> launchList;

    RVAdapter(List<Launch> launchList){
        this.launchList = launchList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public LaunchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        LaunchViewHolder lvh = new LaunchViewHolder(v); // lvh = launch view holder
        return lvh;
    }

    @Override
    public void onBindViewHolder(LaunchViewHolder launchViewHolder, int i) {

        launchViewHolder.launchSequence.setText(launchList.get(i).launchSequence);
        launchViewHolder.launchServiceProvider.setText(launchList.get(i).launchServiceProvider);
        launchViewHolder.launchVehicle.setText(launchList.get(i).launchVehicle);
        launchViewHolder.missionName.setText(launchList.get(i).missionName);

    }

    @Override
    public int getItemCount() {
        return launchList.size();
    }

}
