package com.thoughtworks.assignment.domain.stayDate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class StayDateClassificationTest {

    @Test
    void shouldReturnProperDateClassificationForWeekDays() {
        // Given
        LocalDate date = LocalDate.of(2019, Month.SEPTEMBER, 27);
        // When
        StayDateClassification classification = StayDateClassification.getClassification(date);
        // Then
        assertEquals(classification, StayDateClassification.WEEK_DAY);
    }

    @Test
    void shouldReturnProperDateClassificationForWeekendDays() {
        // Given
        LocalDate date = LocalDate.of(2019, Month.SEPTEMBER, 28);
        // When
        StayDateClassification classification = StayDateClassification.getClassification(date);
        // Then
        assertEquals(classification, StayDateClassification.WEEKEND_DAY);
    }

}