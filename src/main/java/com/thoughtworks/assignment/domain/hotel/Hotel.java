package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;

import java.util.List;

public class Hotel {

    private static final String INVALID_PRICE_TABLE_MESSAGE = "Incomplete table";

    private String name;

    private Double rate;

    private HotelPriceTable priceTable;

    public Hotel(String name, Double rate, HotelPriceTable priceTable) {
        this.name = name;
        this.rate = rate;
        this.priceTable = priceTable;
    }

    public Double getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public Double getTotalPrice(List<ReservationDate> dates, ClientClassification clientClassification) {
        return dates
                .stream()
                .map(date -> getPrice(date, clientClassification))
                .reduce(0.00,(accumulator, price) -> accumulator + price);
    }

    public Double getPrice(ReservationDate date, ClientClassification clientClassification) {
        return priceTable.getPrice(date, clientClassification);
    }
}
