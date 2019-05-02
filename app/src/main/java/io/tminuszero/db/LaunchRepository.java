package io.tminuszero.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class LaunchRepository {
    private String DB_NAME = "Launch.db";

    private LaunchDatabase launchDatabase;

    public LaunchRepository(Context context) {
        launchDatabase = Room.databaseBuilder(context, LaunchDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration().build();
    }

    public void insertLaunch(int launchID, String net, String rocketName,
                             String missionName, int probability, String LSPName,
                             String locationName, String padName, String agencyName,
                             String missionDetails, String hashTag) {
        LaunchEntity launch = new LaunchEntity();

        launch.setLaunchID(launchID);
        launch.setNet(net);
        launch.setRocketName(rocketName);
        launch.setMissionName(missionName);
        launch.setProbability(probability);
        launch.setLSPName(LSPName);
        launch.setLocationName(locationName);
        launch.setPadName(padName);
        launch.setAgencyName(agencyName);
        launch.setMissionDetails(missionDetails);
        launch.setHashTag(hashTag);

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

    public void updateLaunchEntity(final LaunchEntity launch) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                launchDatabase.launchDao().updateLaunchEntity(launch);
                return null;
            }
        }.execute();
    }

    public LaunchEntity getLaunchEntity(final int launchID) {
        LaunchEntity temp = null;

        // TODO: Figure out how this works?
        try {
            temp =
                    new AsyncTask<Void, Void, LaunchEntity>() {
                        @Override
                        protected LaunchEntity doInBackground(Void... voids) {
                            return launchDatabase.launchDao().getLaunchEntity(launchID);
                        }
                    }.execute().get();

        } catch(Exception e) {

        }

        return temp;
    }

    public LiveData<List<LaunchEntity>> getLaunch() {
        return launchDatabase.launchDao().fetchAllLaunches();
    }

    public void deleteAll() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                launchDatabase.launchDao().deleteAll();

                return null;
            }
        }.execute();
    }
}
