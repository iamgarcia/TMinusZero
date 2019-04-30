package io.tminuszero;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class LaunchesFragment extends Fragment {

    private LaunchesTabAdapter mTabAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_launch_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mViewPager = getView().findViewById(R.id.viewPager);
        mTabLayout = getView().findViewById(R.id.tabLayout);

        mTabAdapter = new LaunchesTabAdapter(getFragmentManager());
        mTabAdapter.addFragment(new FollowedLaunchesTabFragment(), "Followed Launches");
        mTabAdapter.addFragment(new UpcomingLaunchesTabFragment(), "Upcoming Launches");
        mViewPager.setAdapter(mTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

}
