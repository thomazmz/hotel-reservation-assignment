package com.thoughtworks.assignment.domain;

public class Client {

    ClientClassification classification;

    Client(ClientClassification classification) {
        this.classification = classification;
    }

    public ClientClassification getClassification() {
        return classification;
    }
}
