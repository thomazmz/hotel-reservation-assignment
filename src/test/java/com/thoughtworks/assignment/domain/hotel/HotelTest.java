package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.price.ClientType;
import com.thoughtworks.assignment.domain.price.PriceTable;
import com.thoughtworks.assignment.domain.price.DayType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    Hotel hotel;

    @BeforeEach
    void createNewHotel() {
        PriceTable priceTable = new PriceTable();
        priceTable.addPrice(DayType.WEEK, ClientType.REGULAR, 50D);
        priceTable.addPrice(DayType.WEEK, ClientType.REWARDS, 40D);
        priceTable.addPrice( DayType.WEEKEND, ClientType.REGULAR, 80D);
        priceTable.addPrice(DayType.WEEKEND, ClientType.REWARDS, 70D);
        hotel = new Hotel("MyBestHotel", 5D, priceTable);
    }

    @Test
    void shouldCalculatePriceForGivenDate() {
        // Given
        LocalDate date = LocalDate.of(2019, Month.SEPTEMBER, 27);
        // When
        Double price = hotel.getPrice(date, ClientType.REWARDS);
        // Then
        assertEquals(40D, price);
    }

    @Test
    void shouldCalculatePriceForDateList() {
        // Given
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2019, Month.SEPTEMBER, 27));
        dates.add(LocalDate.of(2019, Month.SEPTEMBER, 28));
        dates.add(LocalDate.of(2019, Month.SEPTEMBER, 29));
        // When
        Double price = hotel.getTotalPrice(dates, ClientType.REWARDS);
        // Then
        assertEquals(180D, price);
    }
}