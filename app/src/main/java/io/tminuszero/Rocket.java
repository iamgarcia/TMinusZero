package io.tminuszero;

import java.util.ArrayList;

public class Rocket {

    private String name;
    private String config;
    private String family;
    private String wikiURL;
    private String imageURL;
    private ArrayList<Integer> imageSizes = new ArrayList<>();

    Rocket() {
        name = "";
        config = "";
        family = "";
        wikiURL = "";
        imageURL = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setImageSizes(ArrayList<Integer> imageSizes) {
        for(int i = 0; i < imageSizes.size(); i++) {
            this.imageSizes.add(imageSizes.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public String getConfig() {
        return config;
    }

    public String getFamily() {
        return family;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ArrayList<Integer> getImageSizes() {
        return imageSizes;
    }

}