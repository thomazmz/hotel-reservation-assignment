package com.thoughtworks.assignment.domain;

import com.thoughtworks.assignment.domain.client.ClientClassification;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HotelService {

    HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel getCheapestHotel(ClientClassification clientClassification, List<Date> dates) {
        return getHotelsOrderedByLowestPrice(clientClassification, dates).get(0);
    }

    public List<Hotel> getHotelsOrderedByLowestPrice(ClientClassification clientClassification, List<Date> dates) {
        List<Hotel> hotels = hotelRepository.findAll();
        HotelPriceComparator hotelPriceComparator = new HotelPriceComparator(clientClassification, dates);
        Collections.sort(hotels, hotelPriceComparator);
        return hotels;
    }
}