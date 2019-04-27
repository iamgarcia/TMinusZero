package io.tminuszero.api;

import java.util.ArrayList;

public class Launch {

    /* Instantiate classes */
    public LSP lsp = new LSP();
    public Mission mission = new Mission();
    public Rocket rocket = new Rocket();
    public Location location = new Location();

    /* Launch Class variables */
    static int nextSequence = 1;
    private int sequence;
    private int probability;
    private int tbdTime;
    private int tbdDate;
    private String net;
    private String holdReason;
    private String failReason;

    /* Launch Class Default Constructor */
    public Launch() {
        sequence = nextSequence;
        probability = -1;
        tbdTime = -1;
        tbdDate = -1;
        net = "";
        holdReason = "";
        failReason = "";
        nextSequence++;
    }

    /* LSP Class Configuration */
    public void configLSP(String name, String nameAbbrev, String countryCode, String wikiURL) {
        lsp.setName(name);
        lsp.setNameAbbrev(nameAbbrev);
        lsp.setCountryCode(countryCode);
        lsp.setWikiURL(wikiURL);
    }

    /* Mission Class Configuration */
    public void configMission(String name, String description, String type) {
        mission.setName(name);
        mission.setDescription(description);
        mission.setType(type);
    }

    /* Rocket Class Configuration */
    public void configRocket(String name, String config, String family, String wikiURL, String imageURL, ArrayList<Integer> imageSizes) {
        rocket.setName(name);
        rocket.setConfig(config);
        rocket.setFamily(family);
        rocket.setWikiURL(wikiURL);
        rocket.setImageURL(imageURL);
        rocket.setImageSizes(imageSizes);
    }

    /* Location Class Configuration */
    public void configLocation(String name, String countryCode, String padName, String wikiURL, String mapURL, String latitude, String longitude) {

        location.setName(name);
        location.setCountryCode(countryCode);

        location.configPad(padName, wikiURL, mapURL, latitude, longitude);

    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void setTbdTime(int tbdTime) {
        this.tbdTime = tbdTime;
    }

    public void setTbdDate(int tbdDate) {
        this.tbdDate = tbdDate;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public void setHoldReason(String holdReason) {
        this.holdReason = holdReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public int getSequence() {
        return sequence;
    }

    public int getProbability() {
        return probability;
    }

    public int getTbdTime() {
        return tbdTime;
    }

    public int getTbdDate() {
        return tbdDate;
    }

    public String getNet() {
        return net;
    }

    public String getHoldReason() {
        return holdReason;
    }

    public String getFailReason() {
        return failReason;
    }

}

//public class Launch {
//
//    static int instanceCounter = 0;
//    int launchSequence;
//    int tbdDate;
//    int tbdTime;
//    int launchServiceProviderID;
//    ArrayList<Integer> rocketImageSizes = new ArrayList<Integer>();
//
//    String launchServiceProvider;
//    String launchVehicle;
//    String missionName;
//    String launchNET;
//    String holdReason;
//    String failReason;
//    String vidURL;
//    String rocketImageURL;
//
//    Launch() {
//
//        instanceCounter++;
//        launchSequence = instanceCounter;
//        tbdDate = 1;
//        tbdTime = 1;
//        launchServiceProviderID = 0;
//
//        launchServiceProvider = null;
//        launchVehicle = null;
//        missionName = null;
//        launchNET = null;
//        holdReason = null;
//        failReason = null;
//        vidURL = null;
//        rocketImageURL = null;
//
//    }
//
//    Launch(int launchSequence, String launchServiceProvider, String launchVehicle, String missionName) {
//
//        this.launchSequence = launchSequence;
//        this.launchServiceProvider = launchServiceProvider;
//        this.launchVehicle = launchVehicle;
//        this.missionName = missionName;
//
//    }
//
//    void formatURLs(Launch obj) {
//
//        String formattedURL;
//
//        if(vidURL.contains("\\")) {
//            formattedURL = obj.vidURL;
//            formattedURL = formattedURL.replace("\\", "");
//            obj.vidURL = formattedURL;
//        }
//
//        if(rocketImageURL.contains("\\")) {
//            formattedURL = obj.rocketImageURL;
//            formattedURL = formattedURL.replace("\\", "");
//            obj.rocketImageURL = formattedURL;
//        }
//
//    }
//
//}