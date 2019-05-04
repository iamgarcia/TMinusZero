package io.tminuszero.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LaunchDao {
    @Insert
    Long insert(UpcomingLaunchEntity launch);

    @Query("SELECT * FROM UpcomingLaunchEntity")
    LiveData<List<UpcomingLaunchEntity>> fetchAllLaunches();

    @Query("SELECT * FROM UpcomingLaunchEntity WHERE launchID =:launchID")
    UpcomingLaunchEntity getLaunchEntity(int launchID);

    @Query("DELETE FROM UpcomingLaunchEntity")
    void deleteAll();

    @Update
    void updateLaunchEntity(UpcomingLaunchEntity upcomingLaunchEntity);

    @Delete
    void delete(UpcomingLaunchEntity launch);
}
