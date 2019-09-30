package com.thoughtworks.assignment.domain.stayDate;

import java.time.LocalDate;
import java.time.Month;

public class StayDate {

    private LocalDate date;

    public StayDate(Integer year, Month month, Integer day) {
        this.date = LocalDate.of(year, month, day);
    }

    public StayDateClassification getClassification() {
        return StayDateClassification.getClassification(this.date);
    }
}
