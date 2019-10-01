package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;

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

    public Double getPrice(ReservationDate date, ClientClassification clientClassification) {
        return hotelPriceTable.getPrice(date, clientClassification);
    }

    public Double getTotalPrice(List<ReservationDate> dates, ClientClassification clientClassification) {
        return dates
                .stream()
                .map(date -> getPrice(date, clientClassification))
                .reduce(0.00,(a,b) -> a+b);
    }
}
