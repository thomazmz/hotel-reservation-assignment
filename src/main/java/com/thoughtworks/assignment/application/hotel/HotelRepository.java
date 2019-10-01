package com.thoughtworks.assignment.application;

import com.thoughtworks.assignment.domain.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository {

    private static List<Hotel> hotels = new ArrayList<>();

    public void add(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> findAll() {
        return hotels;
    }

}