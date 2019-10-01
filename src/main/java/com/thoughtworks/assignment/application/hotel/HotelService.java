package com.thoughtworks.assignment.application.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.hotel.Hotel;
import com.thoughtworks.assignment.domain.hotel.HotelPriceComparator;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;

import java.util.Collections;
import java.util.List;

public class HotelService {

    HotelRepository hotelRepository;

    public HotelService() {
        this.hotelRepository = new HotelRepository();
    }

    public void create(Hotel hotel) {
        hotelRepository.add(hotel);
    }

    public Hotel getCheapestHotel(ClientClassification clientClassification, List<ReservationDate> dates) {
        return getHotelsOrderedByLowestPrice(clientClassification, dates).get(0);
    }

    public List<Hotel> getHotelsOrderedByLowestPrice(ClientClassification clientClassification, List<ReservationDate> dates) {
        List<Hotel> hotels = hotelRepository.findAll();
        HotelPriceComparator hotelPriceComparator = new HotelPriceComparator(clientClassification, dates);
        Collections.sort(hotels, hotelPriceComparator);
        return hotels;
    }
}