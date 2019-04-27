package io.tminuszero.api;

import java.util.ArrayList;

public class Media {

    private String hashtag;
    private ArrayList<String> lspLinks = new ArrayList<>(); // LSP social media links
    private ArrayList<String> videoLinks = new ArrayList<>();

    Media() {
        this.hashtag = "";
    }

    public  void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setLspLinks(ArrayList<String> lspLinks) {
        for(int i = 0; i < lspLinks.size(); i++) {
            this.lspLinks.add(lspLinks.get(i));
        }
    }

    public void setVideoLinks(ArrayList<String> videoLinks) {
        for(int i = 0; i < videoLinks.size(); i++) {
            this.videoLinks.add(videoLinks.get(i));
        }
    }

    public String getHashtag() {
        return hashtag;
    }

    public ArrayList<String> getLspLinks() {
        return lspLinks;
    }

    public  ArrayList<String> getVideoLinks() {
        return videoLinks;
    }

}
