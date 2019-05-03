package io.tminuszero.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class LaunchEntity implements Serializable {

    @PrimaryKey
    private int launchID;

    /**
     *  No Earlier Than
     *  String
     *  Note: formatted as mm, dd, yyyy hh24:mi:ss UTC
     */
    @ColumnInfo(name = "net")
    private String net;

    /**
     *  Rocket Name
     *  String
     */
    @ColumnInfo(name = "rocket_name")
    private String rocketName;

    /**
     *  Mission Name
     *  String
     */
    @ColumnInfo(name = "mission_name")
    private String missionName;

    /**
     *  Launch Probability
     *  int
     *  Note: will return -1 if unknown to us
     */
    @ColumnInfo(name = "probability")
    private int probability;

    /**
     *  Launch Service Provider Name
     *  String
     */
    @ColumnInfo(name = "lsp_name")
    private String LSPName;

    /**
     *  Location Name
     *  String
     */
    @ColumnInfo(name = "location_name")
    private String locationName;

    /**
     *  Pad Name
     *  String
     */
    @ColumnInfo(name = "pad_name")
    private String padName;

    /**
     *  Agency Name
     *  String
     */
    @ColumnInfo(name = "agency_name")
    private String agencyName;

    /**
     *  Mission Details
     *  String
     */
    @ColumnInfo(name = "mission_details")
    private String missionDetails;

    /**
     *  Hashtag
     *  String
     *  Note: will return "null" if unknown to us
     */
    @ColumnInfo(name = "hash_tag")
    private String hashTag;

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public int getLaunchID() {
        return launchID;
    }

    public void setLaunchID(int launchID) {
        this.launchID = launchID;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public String getLSPName() {
        return LSPName;
    }

    public void setLSPName(String LSPName) {
        this.LSPName = LSPName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPadName() {
        return padName;
    }

    public void setPadName(String padName) {
        this.padName = padName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getMissionDetails() {
        return missionDetails;
    }

    public void setMissionDetails(String missionDetails) {
        this.missionDetails = missionDetails;
    }
}
