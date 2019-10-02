package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.price.ClientType;
import com.thoughtworks.assignment.domain.price.PriceTable;

import java.time.LocalDate;
import java.util.List;

public class Hotel {

    private String name;

    private Double classification;

    private PriceTable priceTable;

    public Hotel(String name, Double classification, PriceTable priceTable) {
        this.name = name;
        this.classification = classification;
        this.priceTable = priceTable;
    }

    public Double getClassification() {
        return classification;
    }

    public String getName() {
        return name;
    }

    public Double getTotalPrice(List<LocalDate> dates, ClientType clientType) {
        return dates
                .stream()
                .map(date -> getPrice(date, clientType))
                .reduce(0.00,(accumulator, price) -> accumulator + price);
    }

    public Double getPrice(LocalDate date, ClientType clientType) {
        return priceTable.getPrice(date, clientType);
    }
}
