package com.thoughtworks.assignment.domain.client;

public enum ClientClassification {
    REWARDS,
    REGULAR;

    public static final int size() {
        return values().length;
    }
}
