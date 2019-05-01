package io.tminuszero.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LaunchEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "concatenated_name")
    public String concatenatedName;

    @ColumnInfo(name = "net")
    public String net;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getConcatenatedName() {
        return concatenatedName;
    }

    public String getNet() {
        return net;
    }
}
