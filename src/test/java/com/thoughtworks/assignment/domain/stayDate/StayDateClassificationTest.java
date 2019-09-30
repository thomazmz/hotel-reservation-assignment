package com.thoughtworks.assignment.domain.stayDate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class StayDateClassificationTest {

    @Test
    void shouldReturnProperDateClassificationForWeekDays() {
        // Given
        LocalDate mondayDate = LocalDate.of(2019, Month.SEPTEMBER, 23);
        LocalDate tuesdayDate = LocalDate.of(2019, Month.SEPTEMBER, 24);
        LocalDate wednesdayDate = LocalDate.of(2019, Month.SEPTEMBER, 25);
        LocalDate thursdayDate = LocalDate.of(2019, Month.SEPTEMBER, 26);
        LocalDate fridayDate = LocalDate.of(2019, Month.SEPTEMBER, 27);

        // When
        StayDateClassification mondayDateClassification = StayDateClassification.getClassification(mondayDate);
        StayDateClassification tuesdayDateClassification = StayDateClassification.getClassification(tuesdayDate);
        StayDateClassification wednesdayDateClassification = StayDateClassification.getClassification(wednesdayDate);
        StayDateClassification thursdayDateClassification = StayDateClassification.getClassification(thursdayDate);
        StayDateClassification fridayDateClassification = StayDateClassification.getClassification(fridayDate);

        // Then
        assertEquals(mondayDateClassification, StayDateClassification.WEEK_DAY);
        assertEquals(tuesdayDateClassification, StayDateClassification.WEEK_DAY);
        assertEquals(wednesdayDateClassification, StayDateClassification.WEEK_DAY);
        assertEquals(thursdayDateClassification, StayDateClassification.WEEK_DAY);
        assertEquals(fridayDateClassification, StayDateClassification.WEEK_DAY);
    }

    @Test
    void shouldReturnProperDateClassificationForWeekendDays() {
        // Given
        LocalDate saturdayDate = LocalDate.of(2019, Month.SEPTEMBER, 28);
        LocalDate sundayDate = LocalDate.of(2019, Month.SEPTEMBER, 29);
        // When
        StayDateClassification saturdayDateClassification = StayDateClassification.getClassification(saturdayDate);
        StayDateClassification sundayDateClassification = StayDateClassification.getClassification(sundayDate);
        // Then
        assertEquals(saturdayDateClassification, StayDateClassification.WEEKEND_DAY);
        assertEquals(sundayDateClassification, StayDateClassification.WEEKEND_DAY);
    }
}