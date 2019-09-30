package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.stayDate.StayDate;
import com.thoughtworks.assignment.domain.stayDate.StayDateClassification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelPriceTableTest {

    @Test
    void shouldAddPriceToPriceTable() {
        // Given
        HotelPriceTable priceTable = new HotelPriceTable();
        priceTable.addPrice(StayDateClassification.WEEK_DAY, ClientClassification.REGULAR, 50D);
        // When
        Double price = priceTable.getPrice(StayDateClassification.WEEK_DAY, ClientClassification.REGULAR);
        // Then
        assertEquals(priceTable.size(), 1);
        assertEquals(price, 50D);
    }

    @Test
    void shouldRemovePriceFromPriceTable() {
        // Given
        HotelPriceTable priceTable = new HotelPriceTable();
        priceTable.addPrice(StayDateClassification.WEEK_DAY, ClientClassification.REGULAR, 50D);
        // When
        priceTable.removePrice(StayDateClassification.WEEK_DAY, ClientClassification.REGULAR);
        // Then
        assertNull(priceTable.getPrice(StayDateClassification.WEEK_DAY, ClientClassification.REGULAR));
        assertEquals(priceTable.size(), 0);
    }

}