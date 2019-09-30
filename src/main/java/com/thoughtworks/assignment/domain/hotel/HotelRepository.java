package com.thoughtworks.assignment.domain;

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
