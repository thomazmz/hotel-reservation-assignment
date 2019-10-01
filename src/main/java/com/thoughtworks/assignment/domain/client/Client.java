package com.thoughtworks.assignment.domain.client;

public class Client {

    private ClientClassification classification;

    public Client(ClientClassification classification) {
        this.classification = classification;
    }

    public ClientClassification getClassification() {
        return classification;
    }
}