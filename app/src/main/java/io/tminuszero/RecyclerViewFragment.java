package io.tminuszero;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Activity {

    private List<Launch> launchList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_followed_launches);

        rv = findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        launchList = new ArrayList<>();
        launchList.add(new Launch(0, "SpaceX", "Dragon & Falcon 9", "CRS-16"));
        launchList.add(new Launch(1, "SpaceX", "Falcon 9", "GPS III Space Vehicle 01"));
        launchList.add(new Launch(1, "SpaceX", "Falcon 9", "Iridium-8"));
        launchList.add(new Launch(2, "ULA", "Delta IV", "NROL-71"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(launchList);
        rv.setAdapter(adapter);
    }

}
