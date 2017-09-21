package com.simplify.constants;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private final String description;

    Sex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
};