package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.price.ClientType;
import com.thoughtworks.assignment.domain.price.DayType;
import com.thoughtworks.assignment.domain.price.PriceTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HoteComparatorStrategyTest {

    static Hotel bestHotel;
    static Hotel fantasticHotel;
    static List<LocalDate> dates;

    @BeforeAll
    static void createHotels() throws Exception {

        DayType weekDay = DayType.WEEK;
        DayType weekendDay = DayType.WEEKEND;
        ClientType regular = ClientType.REGULAR;
        ClientType rewards = ClientType.REWARDS;

        PriceTable bestHotelPriceTable = new PriceTable();
        bestHotelPriceTable.addPrice(weekDay, regular, 110D);
        bestHotelPriceTable.addPrice(weekDay, rewards, 80D);
        bestHotelPriceTable.addPrice(weekendDay, regular, 90D);
        bestHotelPriceTable.addPrice(weekendDay, rewards, 80D);
        bestHotel = new Hotel("BestHotel", 3D, bestHotelPriceTable);

        PriceTable fantasticHotelPriceTable = new PriceTable();
        fantasticHotelPriceTable.addPrice(weekDay, regular, 220D);
        fantasticHotelPriceTable.addPrice(weekDay, rewards, 100D);
        fantasticHotelPriceTable.addPrice(weekendDay, regular, 150D);
        fantasticHotelPriceTable.addPrice(weekendDay, rewards, 40D);
        fantasticHotel = new Hotel("FantasticHotel", 3D, fantasticHotelPriceTable);

        dates = new LinkedList<>();
        dates.add(LocalDate.of(2009, Month.MARCH, 16));
        dates.add(LocalDate.of(2009, Month.MARCH, 17));
        dates.add(LocalDate.of(2009, Month.MARCH, 18));

    }

    @Test
    void shouldReturnNegative() {
        // Given
        ClientType clientType = ClientType.REGULAR;
        HoteComparatorStrategy hoteComparatorStrategy = new HoteComparatorStrategy(clientType, dates);
        // When
        Integer comparatorResult = hoteComparatorStrategy.compare(bestHotel, fantasticHotel);
        // Then
       assertTrue(comparatorResult < 0);
    }

    @Test
    void shouldReturnPositive() {
        // Given
        ClientType clientType = ClientType.REWARDS;
        HoteComparatorStrategy hoteComparatorStrategy = new HoteComparatorStrategy(clientType, dates);
        // When
        Integer comparatorResult = hoteComparatorStrategy.compare(fantasticHotel, bestHotel);
        // Then
        assertFalse(comparatorResult < 0);
    }

    @Test
    void shouldReturnZero() {
        // Given
        ClientType clientType = ClientType.REWARDS;
        HoteComparatorStrategy hoteComparatorStrategy = new HoteComparatorStrategy(clientType, dates);
        // When
        Integer comparatorResult = hoteComparatorStrategy.compare(fantasticHotel, fantasticHotel);
        // Then
        assertTrue(comparatorResult == 0);
    }

}