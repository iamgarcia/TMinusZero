package io.tminuszero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LaunchScheduleFragment extends Fragment {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_launch_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = getView().findViewById(R.id.viewPager);
        tabLayout = getView().findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getFragmentManager());
        adapter.addFragment(new FollowedLaunchesTabFragment(), "Followed Launches");
        adapter.addFragment(new UpcomingLaunchesTabFragment(), "Upcoming Launches");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
