package io.tminuszero.api;

public class FlightStatus {

    private int status;
    private String holdReason;
    private String failReason;

    FlightStatus() {
        this.status = -1;
        this.holdReason = "";
        this.failReason = "";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setHoldReason(String holdReason) {
        this.holdReason = holdReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public int getStatus() {
        return status;
    }

    public String getHoldReason() {
        return holdReason;
    }

    public String getFailReason() {
        return failReason;
    }

}
