package io.tminuszero.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UpcomingLaunchEntity.class}, version = 5, exportSchema = true)
public abstract class LaunchDatabase extends RoomDatabase{
    public abstract LaunchDao launchDao();
}