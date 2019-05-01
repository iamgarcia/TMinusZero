package io.tminuszero.api;

import java.util.ArrayList;

public class Launch {

    /* Instantiate classes */
    public FlightStatus flightStatus = new FlightStatus();
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
    private int launchID;
    private String net;

    /* Launch Class Default Constructor */
    public Launch() {
        sequence = nextSequence;
        probability = -1;
        tbdTime = -1;
        tbdDate = -1;
        net = "";
        nextSequence++;
        launchID = -1;
    }

    /* Launch Class Configuration */
    public void configLaunch(String name, String net, int tbdTime, int tbdDate, int probability, int launchID) {
        setNet(net);
        setTbdTime(tbdTime);
        setTbdDate(tbdDate);
        setProbability(probability);
        setLaunchID(launchID);
    }

    public void configFlightStatus(int status, String holdReason, String failReason) {
        flightStatus.setStatus(status);
        flightStatus.setHoldReason(holdReason);
        flightStatus.setFailReason(failReason);
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

    public void setLaunchID(int launchID) { this.launchID = launchID;}

    public void setTbdDate(int tbdDate) {
        this.tbdDate = tbdDate;
    }

    public void setNet(String net) { this.net = net; }

    public int getLaunchID() {return launchID;}

    public int getSequence() { return sequence; }

    public int getProbability() { return probability; }

    public int getTbdTime() { return tbdTime; }

    public int getTbdDate() { return tbdDate; }

    public String getNet() { return net; }
}