package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.price.ClientType;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class HotePriceComparator implements Comparator<Hotel> {

    private List<LocalDate> dates;

    private ClientType clientType;

    public HotePriceComparator(ClientType clientType, List<LocalDate> dates) {
        this.clientType = clientType;
        this.dates = dates;
    }

    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        Double firstHotelPrice = firstHotel.getTotalPrice(this.dates, this.clientType);
        Double secondHotelPrice = secondHotel.getTotalPrice(this.dates, this.clientType);
        if(firstHotelPrice.equals(secondHotelPrice)) {
            Double firstHotelClassification =  firstHotel.getClassification();
            Double secondHotelClassification = secondHotel.getClassification();
            return Double.compare(secondHotelClassification, firstHotelClassification);
        }
        return Double.compare(firstHotelPrice, secondHotelPrice);
    }
}
