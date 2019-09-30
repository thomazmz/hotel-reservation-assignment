package com.thoughtworks.assignment.domain;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.hotel.Hotel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class HotelPriceComparator implements Comparator<Hotel> {

    private List<Date> dates = new ArrayList<>();

    private ClientClassification clientClassification;

    HotelPriceComparator(ClientClassification clientClassification, List<Date> dates) {
        this.clientClassification = clientClassification;
        this.dates = dates;
    }

    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        Double firstHotelPrice = firstHotel.getTotalPrice(this.clientClassification, this.dates);
        Double secondHotelPrice = firstHotel.getTotalPrice(this.clientClassification, this.dates);
        if(firstHotelPrice == secondHotelPrice) {
            Double firstHotelRate =  firstHotel.getRate();
            Double secondHotelRate = secondHotel.getRate();
            return Double.compare(firstHotelRate, secondHotelRate);
        }
        return Double.compare(firstHotelPrice, secondHotelPrice);
    }
}
