package com.thoughtworks.assignment.domain.price;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PriceTableTest {

    PriceTable priceTable;

    @BeforeEach
    void createNewHotels() {
        priceTable = new PriceTable();
        priceTable.addPrice(DayType.WEEK, ClientType.REGULAR, 50D);
        priceTable.addPrice(DayType.WEEK, ClientType.REWARDS, 40D);
        priceTable.addPrice( DayType.WEEKEND, ClientType.REGULAR, 80D);
    }

    @Test
    void shouldAddPriceToPriceTable() {
        // Given
        priceTable.addPrice(DayType.WEEKEND, ClientType.REWARDS, 70D);
        // When
        Double price = priceTable.getPrice(DayType.WEEKEND, ClientType.REWARDS);
        // Then
        assertEquals(4, priceTable.size());
        assertEquals(70D, price);
    }

    @Test
    void shouldRemovePriceFromPriceTable() {
        // When
        priceTable.removePrice(DayType.WEEK, ClientType.REGULAR);
        // Then
        assertNull(priceTable.getPrice(DayType.WEEK, ClientType.REGULAR));
        assertEquals(2, priceTable.size());
    }

    @Test
    void shouldReturnPriceGivenDateAndClientTye() {
        // Given
        LocalDate date = LocalDate.of(2019, Month.SEPTEMBER, 27);
        // When
        Double regularPrice = priceTable.getPrice(date, ClientType.REGULAR);
        Double rewardPrice = priceTable.getPrice(date, ClientType.REWARDS);
        // Then
        assertEquals(50D, regularPrice);
        assertEquals(40D, rewardPrice);
    }

}