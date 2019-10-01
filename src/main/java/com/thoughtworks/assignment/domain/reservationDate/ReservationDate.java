package com.thoughtworks.assignment.domain.reservationDate;

import java.time.LocalDate;
import java.time.Month;

public class ReservationDate {

    private LocalDate date;

    public ReservationDate(Integer year, Month month, Integer day) {
        this.date = LocalDate.of(year, month, day);
    }

    public ReservationDateClassification getClassification() {
        return ReservationDateClassification.getClassification(this.date);
    }
}
