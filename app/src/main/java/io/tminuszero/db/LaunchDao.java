package io.tminuszero.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LaunchDao {
    @Insert
    Long insert(LaunchEntity launch);

    @Query("SELECT * FROM LaunchEntity")
    LiveData<List<LaunchEntity>> fetchAllLaunches();

    @Delete
    void delete(LaunchEntity launch);
}
