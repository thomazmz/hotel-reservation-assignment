package com.thoughtworks.assignment.application.hotel;

import com.thoughtworks.assignment.domain.price.ClientType;
import com.thoughtworks.assignment.domain.hotel.Hotel;
import com.thoughtworks.assignment.domain.hotel.HotePriceComparator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class HotelService {

    private HotelRepository repository;

    public HotelService() {
        this.repository = new HotelRepository();
    }

    public Hotel getCheapestHotel(ClientType clientType, List<LocalDate> dates) {
        return getHotelsOrderedByLowestPrice(clientType, dates).get(0);
    }

    public List<Hotel> getHotelsOrderedByLowestPrice(ClientType clientType, List<LocalDate> dates) {
        List<Hotel> hotels = repository.findAll();
        HotePriceComparator hotePriceComparator = new HotePriceComparator(clientType, dates);
        Collections.sort(hotels, hotePriceComparator);
        return hotels;
    }
}