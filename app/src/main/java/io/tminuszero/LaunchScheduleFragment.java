package io.tminuszero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LaunchScheduleFragment extends Fragment {

    private TabAdapter mTabAdapter;
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

        mTabAdapter = new TabAdapter(getFragmentManager());
        mTabAdapter.addFragment(new FollowedLaunchesTabFragment(), "Followed Launches");
        mTabAdapter.addFragment(new UpcomingLaunchesTabFragment(), "Upcoming Launches");
        mViewPager.setAdapter(mTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

}
