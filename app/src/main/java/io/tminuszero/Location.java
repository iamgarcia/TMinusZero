package io.tminuszero;

public class Location {

    private String padName;
    private String wikiURL;
    private String mapURL;
    private String site;
    private String countryCode;
    private Long latitude;
    private Long longitude;

    Location() {
        padName = "";
        wikiURL = "";
        mapURL = "";
        site = "";
        countryCode = "";
        latitude = null;
        longitude = null;
    }

    public void setPadName(String padName) {
        this.padName = padName;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public void setMapURL(String mapURL) {
        this.mapURL = mapURL;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getPadName() {
        return padName;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public String getMapURL() {
        return mapURL;
    }

    public String getSite() {
        return site;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

}
