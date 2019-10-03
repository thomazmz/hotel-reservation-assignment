package com.thoughtworks.assignment.domain.price;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTypeTest {

    @ParameterizedTest()
    @CsvSource({
        "2019, SEPTEMBER, 23",
        "2019, SEPTEMBER, 24",
        "2019, SEPTEMBER, 25",
        "2019, SEPTEMBER, 26",
        "2019, SEPTEMBER, 27"
    })
    void shouldReturnProperDateClassificationForWeekDays(int year, String month, int day) {
        // Given
        LocalDate date = LocalDate.of(year, Month.valueOf(month), day);
        // When
        DayType dateClassification = DayType.getType(date);
        // Then
        assertEquals(DayType.WEEKDAY, dateClassification);
    }

    @ParameterizedTest()
    @CsvSource({
            "2019, SEPTEMBER, 28",
            "2019, SEPTEMBER, 29"
    })
    void shouldReturnProperDateClassificationForWeekendDays(int year, String month, int day) {
        // Given
        LocalDate date = LocalDate.of(year, Month.valueOf(month), day);
        // When
        DayType dateClassification = DayType.getType(date);
        // Then
        assertEquals(DayType.WEEKEND, dateClassification);
    }
}