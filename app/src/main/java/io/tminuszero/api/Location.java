package io.tminuszero.api;

public class Location {

    private String name;
    private String countryCode;

    public Pads pads = new Pads();


    Location() {
        this.name = " ";
        this.countryCode = " ";
    }

    /* Pads configuration */
    public void configPad(String name, String wikiURL, String mapURL, String latitude, String longitude) {
        pads.setName(name);
        pads.setWikiURL(wikiURL);
        pads.setMapURL(mapURL);
        pads.setLatitude(latitude);
        pads.setLongitude(longitude);
    }

    public void setName(String name) { this.name = name; }

    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getName() { return name; }

    public String getCountryCode() { return countryCode; }
}
