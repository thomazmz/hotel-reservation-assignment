package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDateClassification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class HotelPriceTableTest {

    HotelPriceTable priceTable;

    @BeforeEach
    void createNewHotel() {
        // Given
        priceTable = new HotelPriceTable();
        priceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR, 50D);
        priceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REWARDS, 40D);
        priceTable.addPrice( ReservationDateClassification.WEEKEND_DAY, ClientClassification.REGULAR, 80D);
    }

    @Test
    void shouldAddPriceToPriceTable() {
        // Given
        priceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REWARDS, 70D);
        // When
        Double price = priceTable.getPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REWARDS);
        // Then
        assertEquals(4, priceTable.size());
        assertEquals(70D, price);
    }

    @Test
    void shouldRemovePriceFromPriceTable() {
        // When
        priceTable.removePrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR);
        // Then
        assertNull(priceTable.getPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR));
        assertEquals(2, priceTable.size());
    }

    @Test
    void shouldReturnPriceGivenDateAndClientTye() {
        // Given
        ReservationDate date = new ReservationDate(2019, Month.SEPTEMBER, 27);
        // When
        Double regularPrice = priceTable.getPrice(date, ClientClassification.REGULAR);
        Double rewardPrice = priceTable.getPrice(date, ClientClassification.REWARDS);
        // Then
        assertEquals(50D, regularPrice);
        assertEquals(40D, rewardPrice);
    }

}