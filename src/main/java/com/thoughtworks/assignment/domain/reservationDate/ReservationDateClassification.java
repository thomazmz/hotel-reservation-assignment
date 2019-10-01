package com.thoughtworks.assignment.domain.reservationDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum ReservationDateClassification {
    WEEK_DAY,
    WEEKEND_DAY;

    public static ReservationDateClassification getClassification(LocalDate date) {
        if(DayOfWeek.from(date) == DayOfWeek.SATURDAY || DayOfWeek.from(date) == DayOfWeek.SUNDAY) {
            return WEEKEND_DAY;
        }
        return WEEK_DAY;
    }
}