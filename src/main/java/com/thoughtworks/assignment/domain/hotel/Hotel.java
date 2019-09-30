package com.thoughtworks.assignment.domain;

import com.thoughtworks.assignment.domain.client.ClientClassification;

import java.util.Date;
import java.util.List;

public class Hotel {

    private String name;

    private Double rate;

    private HotelPriceTable hotelPriceTable;

    public Hotel(String name, Double rate, HotelPriceTable hotelPriceTable) {
        this.name = name;
        this.rate = rate;
        this.hotelPriceTable = hotelPriceTable;
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }

    public Double getPrice(ClientClassification clientClassification, Date date) {
        return hotelPriceTable.getPrice(date, clientClassification);
    }

    public Double getTotalPrice(ClientClassification clientClassification, List<Date> dates) {
        return dates
                .stream()
                .map(date -> getPrice(clientClassification, date))
                .reduce(0.00,(a,b) -> a+b);
    }
}
