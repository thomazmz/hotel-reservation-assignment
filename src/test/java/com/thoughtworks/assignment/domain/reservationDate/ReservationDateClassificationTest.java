package com.thoughtworks.assignment.domain.reservationDate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDateClassificationTest {

    @Test
    void shouldReturnProperDateClassificationForWeekDays() {
        // Given
        LocalDate mondayDate = LocalDate.of(2019, Month.SEPTEMBER, 23);
        LocalDate tuesdayDate = LocalDate.of(2019, Month.SEPTEMBER, 24);
        LocalDate wednesdayDate = LocalDate.of(2019, Month.SEPTEMBER, 25);
        LocalDate thursdayDate = LocalDate.of(2019, Month.SEPTEMBER, 26);
        LocalDate fridayDate = LocalDate.of(2019, Month.SEPTEMBER, 27);

        // When
        ReservationDateClassification mondayDateClassification = ReservationDateClassification.getClassification(mondayDate);
        ReservationDateClassification tuesdayDateClassification = ReservationDateClassification.getClassification(tuesdayDate);
        ReservationDateClassification wednesdayDateClassification = ReservationDateClassification.getClassification(wednesdayDate);
        ReservationDateClassification thursdayDateClassification = ReservationDateClassification.getClassification(thursdayDate);
        ReservationDateClassification fridayDateClassification = ReservationDateClassification.getClassification(fridayDate);

        // Then
        assertEquals(mondayDateClassification, ReservationDateClassification.WEEK_DAY);
        assertEquals(tuesdayDateClassification, ReservationDateClassification.WEEK_DAY);
        assertEquals(wednesdayDateClassification, ReservationDateClassification.WEEK_DAY);
        assertEquals(thursdayDateClassification, ReservationDateClassification.WEEK_DAY);
        assertEquals(fridayDateClassification, ReservationDateClassification.WEEK_DAY);
    }

    @Test
    void shouldReturnProperDateClassificationForWeekendDays() {
        // Given
        LocalDate saturdayDate = LocalDate.of(2019, Month.SEPTEMBER, 28);
        LocalDate sundayDate = LocalDate.of(2019, Month.SEPTEMBER, 29);
        // When
        ReservationDateClassification saturdayDateClassification = ReservationDateClassification.getClassification(saturdayDate);
        ReservationDateClassification sundayDateClassification = ReservationDateClassification.getClassification(sundayDate);
        // Then
        assertEquals(saturdayDateClassification, ReservationDateClassification.WEEKEND_DAY);
        assertEquals(sundayDateClassification, ReservationDateClassification.WEEKEND_DAY);
    }
}