package com.thoughtworks.assignment.domain.client;

public enum ClientClassification {
    REWARDS("Rewards"),
    REGULAR("Rewards");

    private String name;

    private ClientClassification(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
