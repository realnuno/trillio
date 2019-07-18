package com.Ian.trillio.constants;

public enum KidsFriendlyStatus {

    APPROVED("approved"),
    REJECTED("rejected"),
    UNKNOWN("unknown");

    private KidsFriendlyStatus(String status) {
        this.status = status;
    }

    private String status;
}
