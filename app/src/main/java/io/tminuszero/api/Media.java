package io.tminuszero.api;

import java.util.ArrayList;

public class Media {

    private String hashtag;
    private ArrayList<String> infoURLs = new ArrayList<>(); // LSP social media links
    private ArrayList<String> vidURLs = new ArrayList<>();

    Media() {
        this.hashtag = "";
    }

    public  void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setInfoURLs(ArrayList<String> infoURLs) {
        for(int i = 0; i < infoURLs.size(); i++) {
            this.infoURLs.add(infoURLs.get(i));
        }
    }

    public void setVidURLs(ArrayList<String> vidURLs) {
        for(int i = 0; i < vidURLs.size(); i++) {
            this.vidURLs.add(vidURLs.get(i));
        }
    }

    public String getHashtag() {
        return hashtag;
    }

    public ArrayList<String> getInfoURLs() {
        return infoURLs;
    }

    public  ArrayList<String> getVidURLs() {
        return vidURLs;
    }

}
