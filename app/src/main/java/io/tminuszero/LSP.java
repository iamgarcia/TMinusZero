package io.tminuszero;

public class LSP {

    private String name;
    private String nameAbbrev;
    private String countryCode;
    private String wikiURL;

    LSP() {
        name = "";
        nameAbbrev = "";
        countryCode = "";
        wikiURL = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameAbbrev(String nameAbbrev) {
        this.nameAbbrev = nameAbbrev;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public String getName() {
        return name;
    }

    public String getNameAbbrev() {
        return nameAbbrev;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getWikiURL() {
        return wikiURL;
    }

}