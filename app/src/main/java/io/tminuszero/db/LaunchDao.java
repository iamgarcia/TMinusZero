package io.tminuszero.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface LaunchDao {
    @Insert
    Long insert(LaunchEntity launch);

    @Delete
    void delete(LaunchEntity launch);
}
