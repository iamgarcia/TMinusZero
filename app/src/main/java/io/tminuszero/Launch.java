package io.tminuszero;

import java.util.ArrayList;

public class Launch {

    static int instanceCounter;
    int launchSequence;
    int tbdDate;
    int tbdTime;
    int launchServiceProviderID;
    ArrayList<Integer> rocketImageSizes = new ArrayList<Integer>();

    String launchServiceProvider;
    String launchVehicle;
    String missionName;
    String launchNET;
    String holdReason;
    String failReason;
    String vidURL;
    String rocketImageURL;

    Launch() {
        
        instanceCounter++;
        launchSequence = instanceCounter;
        tbdDate = 1;
        tbdTime = 1;
        launchServiceProviderID = 0;

        launchServiceProvider = null;
        launchVehicle = null;
        missionName = null;
        launchNET = null;
        holdReason = null;
        failReason = null;
        vidURL = null;
        rocketImageURL = null;

    }

    Launch(int launchSequence, String launchServiceProvider, String launchVehicle, String missionName) {

        this.launchSequence = launchSequence;
        this.launchServiceProvider = launchServiceProvider;
        this.launchVehicle = launchVehicle;
        this.missionName = missionName;

    }

    void formatURLs(Launch obj) {

        String formattedURL;

        if(vidURL.contains("\\")) {
            formattedURL = obj.vidURL;
            formattedURL = formattedURL.replace("\\", "");
            obj.vidURL = formattedURL;
        }

        if(rocketImageURL.contains("\\")) {
            formattedURL = obj.rocketImageURL;
            formattedURL = formattedURL.replace("\\", "");
            obj.rocketImageURL = formattedURL;
        }

    }

}
