package io.tminuszero.api;

public class Pads {
    private String name;
    private String wikiURL;
    private String mapURL;
    private String latitude;
    private String longitude;

    public Pads() {
        name = "";
        wikiURL = "";
        mapURL = "";
        latitude = null;
        longitude = null;
    }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }

    public void setMapURL(String mapURL) { this.mapURL = mapURL; }

    public void setName(String name) { this.name = name; }

    public void setWikiURL(String wikiURL) { this.wikiURL = wikiURL; }

    public String getLatitude() { return latitude; }

    public String getLongitude() { return longitude; }

    public String getMapURL() { return mapURL; }

    public String getName() { return name; }

    public String getWikiURL() { return wikiURL; }
}
