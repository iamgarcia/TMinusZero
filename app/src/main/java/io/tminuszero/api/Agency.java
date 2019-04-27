package io.tminuszero.api;

import java.util.ArrayList;

public class Agency {

    private String name;
    private String abbrev;
    private String countryCode;
    private String wikiURL;
    private ArrayList<String> infoURLs = new ArrayList<>();

    Agency() {
        this.name = "";
        this.abbrev = "";
        this.countryCode = "";
        this.wikiURL = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public void setInfoURLs(ArrayList<String> infoURLs) {
        for(int i = 0; i < infoURLs.size(); i++) {
            this.infoURLs.add(infoURLs.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public  ArrayList<String> getInfoURLs() {
        return infoURLs;
    }

}
