package com.thoughtworks.assignment.application.hotel;

import com.thoughtworks.assignment.domain.price.ClientType;
import com.thoughtworks.assignment.domain.hotel.Hotel;
import com.thoughtworks.assignment.domain.hotel.HoteComparatorStrategy;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class HotelService {

    HotelRepository hotelRepository;

    public HotelService() {
        this.hotelRepository = new HotelRepository();
    }

    public Hotel getCheapestHotel(ClientType clientType, List<LocalDate> dates) {
        return getHotelsOrderedByLowestPrice(clientType, dates).get(0);
    }

    public List<Hotel> getHotelsOrderedByLowestPrice(ClientType clientType, List<LocalDate> dates) {
        List<Hotel> hotels = hotelRepository.findAll();
        HoteComparatorStrategy hoteComparatorStrategy = new HoteComparatorStrategy(clientType, dates);
        Collections.sort(hotels, hoteComparatorStrategy);
        return hotels;
    }
}