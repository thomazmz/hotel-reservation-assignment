package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;

import java.util.Comparator;
import java.util.List;

public class HotelPriceComparator implements Comparator<Hotel> {

    private List<ReservationDate> dates;

    private ClientClassification clientClassification;

    public HotelPriceComparator(ClientClassification clientClassification, List<ReservationDate> dates) {
        this.clientClassification = clientClassification;
        this.dates = dates;
    }

    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        Double firstHotelPrice = firstHotel.getTotalPrice(this.dates, this.clientClassification);
        Double secondHotelPrice = secondHotel.getTotalPrice(this.dates, this.clientClassification);
        if(firstHotelPrice.equals(secondHotelPrice)) {
            Double firstHotelRate =  firstHotel.getRate();
            Double secondHotelRate = secondHotel.getRate();
            return Double.compare(secondHotelRate, firstHotelRate);
        }
        return Double.compare(firstHotelPrice, secondHotelPrice);
    }
}
