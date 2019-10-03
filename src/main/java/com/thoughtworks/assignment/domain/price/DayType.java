package com.thoughtworks.assignment.domain.price;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum DayType {
    WEEKDAY,
    WEEKEND;

    public static final DayType getType(LocalDate date) {
        if(DayOfWeek.from(date) == DayOfWeek.SATURDAY || DayOfWeek.from(date) == DayOfWeek.SUNDAY) {
            return WEEKEND;
        }
        return WEEKDAY;
    }
}