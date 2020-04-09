package com.pluralsight.conference.model;

import javax.validation.constraints.NotEmpty;

public class Registration {

    @NotEmpty //doesn't allow blank, empty space, etc..
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
