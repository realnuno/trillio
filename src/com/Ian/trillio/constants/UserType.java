package com.Ian.trillio.constants;

public enum UserType {
    USER("user"),
    EDITOR("editor"),
    CHIEF_EDITOR("chiefeditor");

    private UserType(String userType) {
        this.userType = userType;
    }

    private String userType;
}
