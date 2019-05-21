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
import io.tminuszero.db.UpcomingLaunchEntity;

public class UpcomingLaunchesRVAdapter extends RecyclerView.Adapter<UpcomingLaunchesRVAdapter.LaunchViewHolder> {

    private ArrayList<UpcomingLaunchEntity> upcomingLaunchEntities;

    UpcomingLaunchesRVAdapter(ArrayList<UpcomingLaunchEntity> upcomingLaunchEntities){
        this.upcomingLaunchEntities = upcomingLaunchEntities;
    }

    @NonNull
    @Override
    public LaunchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.launches_items, viewGroup, false);
        return new LaunchViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(LaunchViewHolder launchViewHolder, int i) {
        UpcomingLaunchEntity entity = upcomingLaunchEntities.get(i);

        int green = Color.parseColor("#4CAF50");
        int red = Color.parseColor("#FF0000");

        switch(entity.getFlightStatus()) {
            case 1:
                launchViewHolder.launchStatus.setColorFilter(green);
                break;

            case 2:
                launchViewHolder.launchStatus.setColorFilter(red);
                break;

            default:
                break;
        }

        launchViewHolder.launchVehicle.setText(entity.getRocketName());
        launchViewHolder.missionName.setText(entity.getMissionName());

        // TODO: Find a better way to do this.
        launchViewHolder.rocketID = entity.getLaunchID();
    }

    @Override
    public int getItemCount() {
        return  (upcomingLaunchEntities != null) ? upcomingLaunchEntities.size() : 0;
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
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
                }
            });
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public int setColorGreen() {
        return Color.parseColor("#4CAF50");
    }

    public int setColorRed() {
        return Color.parseColor("#FF0000");
    }

}
