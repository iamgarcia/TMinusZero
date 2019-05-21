package io.tminuszero.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UpcomingLaunchEntity implements Serializable {

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

    /**
     * Flight Status
     * Int
     * Note: (1 Green, 2 Red, 3 Success, 4 Failed)
     */
    @ColumnInfo(name = "flight_status")
    private int flightStatus;

    /**
     * Flight Hold Reason
     * String
     */
    @ColumnInfo(name = "flight_hold_reason")
    private String flightHoldReason;

    /**
     * Flight Fail Reason
     * String
     */
    @ColumnInfo(name = "flight_fail_reason")
    private String flightFailReason;

    /**
     * Rocket Image URL
     * String
     */
    @ColumnInfo(name = "rocket_image_url")
    private String rocketImageURL;

    public UpcomingLaunchEntity() {
        setAll(0, null, null,
                null, 0, null,
                null, null, null,
                null, null, 0,
                null, null, null);
    }

    public void setAll(int launchID, String net, String rocketName,
                  String missionName, int probability, String LSPName,
                  String locationName, String padName, String agencyName,
                  String missionDetails, String hashTag, int flightStatus,
                  String flightHoldReason, String flightFailReason, String rocketImageURL) {

        this.launchID = launchID;
        this.net = net;
        this.rocketName = rocketName;
        this.missionName = missionName;
        this.probability = probability;
        this.LSPName = LSPName;
        this.locationName = locationName;
        this.padName = padName;
        this.agencyName = agencyName;
        this.missionDetails = missionDetails;
        this.hashTag = hashTag;
        this.flightStatus = flightStatus;
        this.flightHoldReason = flightHoldReason;
        this.flightFailReason = flightFailReason;
        this.rocketImageURL = rocketImageURL;
    }

    /*
    public UpcomingLaunchEntity(int launchID, String net, String rocketName,
                                String missionName, int probability, String LSPName,
                                String locationName, String padName, String agencyName,
                                String missionDetails, String hashTag) {
        this.launchID = launchID;
        this.net = net;
        this.rocketName = rocketName;
        this.missionName = missionName;
        this.probability = probability;
        this.LSPName = LSPName;
        this.locationName = locationName;
        this.padName = padName;
        this.agencyName = agencyName;
        this.missionDetails = missionDetails;
        this.hashTag = hashTag;
    }*/

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
    public int getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(int flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getFlightHoldReason() {
        return flightHoldReason;
    }

    public void setFlightHoldReason(String flightHoldReason) {
        this.flightHoldReason = flightHoldReason;
    }

    public String getFlightFailReason() {
        return flightFailReason;
    }

    public void setFlightFailReason(String flightFailReason) {
        this.flightFailReason = flightFailReason;
    }

    public String getRocketImageURL() {
        return rocketImageURL;
    }

    public void setRocketImageURL(String rocketImageURL) {
        this.rocketImageURL = rocketImageURL;
    }
}
