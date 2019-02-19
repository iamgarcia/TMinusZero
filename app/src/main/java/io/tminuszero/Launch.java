package io.tminuszero;

public class Launch {

    int launchSequence;
    String launchServiceProvider;
    String launchVehicle;
    String missionName;

    Launch(int launchSequence, String launchServiceProvider, String launchVehicle, String missionName) {
        this.launchSequence = launchSequence;
        this.launchServiceProvider = launchServiceProvider;
        this.launchVehicle = launchVehicle;
        this.missionName = missionName;
    }

}
