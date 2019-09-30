package com.thoughtworks.assignment.domain.stayDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum StayDateClassification {
    WEEK_DAY,
    WEEKEND_DAY;

    public static StayDateClassification getClassification(LocalDate date) {
        if(DayOfWeek.from(date) == DayOfWeek.SATURDAY || DayOfWeek.from(date) == DayOfWeek.SUNDAY) {
            return WEEKEND_DAY;
        }
        return WEEK_DAY;
    }
}