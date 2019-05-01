package io.tminuszero.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

public class LaunchRepository {
    private String DB_NAME = "Launch.db";

    private LaunchDatabase launchDatabase;

    public LaunchRepository(Context context) {
        launchDatabase = Room.databaseBuilder(context, LaunchDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration().build();
    }

    public void insertLaunch(String name, String net) {
        LaunchEntity launch = new LaunchEntity();

        launch.concatenatedName = name;
        launch.net = net;

        insertLaunch(launch);
    }

    public void insertLaunch(final LaunchEntity entity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                launchDatabase.launchDao().insert(entity);

                return null;
            }
        }.execute();
    }
}
