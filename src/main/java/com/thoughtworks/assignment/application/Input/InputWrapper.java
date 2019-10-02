package com.thoughtworks.assignment.application.input;

import com.thoughtworks.assignment.domain.price.ClientType;

import java.time.LocalDate;
import java.util.List;

public class InputWrapper {

    private static final InputParser parser = new InputParser();

    private List<LocalDate> dates;

    private ClientType clientType;

    public InputWrapper(List<LocalDate> dates, ClientType clientType) {
        this.dates = dates;
        this.clientType = clientType;
    }

    public InputWrapper of(String inputString) throws Exception {
        return parser.parse(inputString);
    }

    public List<LocalDate> getDates() {
        return this.dates;
    }

    public ClientType getClientType() {
        return clientType;
    }
}
