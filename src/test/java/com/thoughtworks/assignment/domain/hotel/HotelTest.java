package com.thoughtworks.assignment.domain.hotel;

import com.thoughtworks.assignment.domain.client.ClientClassification;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDate;
import com.thoughtworks.assignment.domain.reservationDate.ReservationDateClassification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    Hotel hotel;

    @BeforeEach
    void createNewHotel() throws Exception {
        // Given
        HotelPriceTable priceTable = new HotelPriceTable();
        priceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REGULAR, 50D);
        priceTable.addPrice(ReservationDateClassification.WEEK_DAY, ClientClassification.REWARDS, 40D);
        priceTable.addPrice( ReservationDateClassification.WEEKEND_DAY, ClientClassification.REGULAR, 80D);
        priceTable.addPrice(ReservationDateClassification.WEEKEND_DAY, ClientClassification.REWARDS, 70D);
        hotel = new Hotel("MyBestHotel", 5D, priceTable);
    }

    @Test
    void shouldCalculatePriceForGivenDate() {
        // Given
        ReservationDate date = new ReservationDate(2019, Month.SEPTEMBER, 27);
        // When
        Double price = hotel.getPrice(date, ClientClassification.REWARDS);
        // Then
        assertEquals(40D, price);
    }

    @Test
    void shouldCalculatePriceForDateList() {
        // Given
        List<ReservationDate> dates = new ArrayList<>();
        dates.add(new ReservationDate(2019, Month.SEPTEMBER, 27));
        dates.add(new ReservationDate(2019, Month.SEPTEMBER, 28));
        dates.add(new ReservationDate(2019, Month.SEPTEMBER, 29));
        // When
        Double price = hotel.getTotalPrice(dates, ClientClassification.REWARDS);
        // Then
        assertEquals(180D, price);
    }
}