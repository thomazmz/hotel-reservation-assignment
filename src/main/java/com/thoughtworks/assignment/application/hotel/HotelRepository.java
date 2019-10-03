package com.thoughtworks.assignment.application.hotel;

import com.thoughtworks.assignment.domain.hotel.Hotel;
import com.thoughtworks.assignment.domain.price.ClientType;
import com.thoughtworks.assignment.domain.price.DayType;
import com.thoughtworks.assignment.domain.price.PriceTable;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository {

    private List<Hotel> hotels = new ArrayList<>();

    public HotelRepository() {

        PriceTable lakewoodPriceTable = new PriceTable();
        lakewoodPriceTable.addPrice(DayType.WEEKDAY, ClientType.REGULAR, 110D);
        lakewoodPriceTable.addPrice(DayType.WEEKDAY, ClientType.REWARDS, 80D);
        lakewoodPriceTable.addPrice(DayType.WEEKEND, ClientType.REGULAR, 90D);
        lakewoodPriceTable.addPrice(DayType.WEEKEND, ClientType.REWARDS, 80D);
        Hotel lakewood = new Hotel("Lakewood", 3D, lakewoodPriceTable);

        PriceTable bridgewoodPriceTable = new PriceTable();
        bridgewoodPriceTable.addPrice(DayType.WEEKDAY, ClientType.REGULAR, 160D);
        bridgewoodPriceTable.addPrice(DayType.WEEKDAY, ClientType.REWARDS, 110D);
        bridgewoodPriceTable.addPrice(DayType.WEEKEND, ClientType.REGULAR, 60D);
        bridgewoodPriceTable.addPrice(DayType.WEEKEND, ClientType.REWARDS, 50D);
        Hotel bridgewood = new Hotel("Bridgewood", 4D, bridgewoodPriceTable);

        PriceTable ridgewoodPriceTable = new PriceTable();
        ridgewoodPriceTable.addPrice(DayType.WEEKDAY, ClientType.REGULAR, 220D);
        ridgewoodPriceTable.addPrice(DayType.WEEKDAY, ClientType.REWARDS, 100D);
        ridgewoodPriceTable.addPrice(DayType.WEEKEND, ClientType.REGULAR, 150D);
        ridgewoodPriceTable.addPrice(DayType.WEEKEND, ClientType.REWARDS, 40D);
        Hotel ridgewood = new Hotel("Ridgewood", 5D, ridgewoodPriceTable);

        hotels.add(lakewood);
        hotels.add(bridgewood);
        hotels.add(ridgewood);

    }

    public List<Hotel> findAll() {
        return hotels;
    }

}
