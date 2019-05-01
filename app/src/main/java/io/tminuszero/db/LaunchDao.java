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
    Long insert(LaunchEntity launch);

    @Query("SELECT * FROM LaunchEntity")
    LiveData<List<LaunchEntity>> fetchAllLaunches();

    @Query("SELECT * FROM LaunchEntity WHERE launchID =:launchID")
    LaunchEntity getLaunchEntity(int launchID);

    @Query("DELETE FROM launchentity")
    void deleteAll();

    @Update
    void updateLaunchEntity(LaunchEntity launchEntity);

    @Delete
    void delete(LaunchEntity launch);
}
