package io.tminuszero.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UpcomingLaunchEntity.class}, version = 6, exportSchema = false)
public abstract class LaunchDatabase extends RoomDatabase{
    public abstract LaunchDao launchDao();
}