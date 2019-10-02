package com.thoughtworks.assignment.application.input;

import com.thoughtworks.assignment.domain.price.ClientType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class InputParser {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy(E)");

    public static InputWrapper parse(String string) throws Exception {

        String clientClassificationString = string.substring(0, string.indexOf(':')).trim().toUpperCase();
        ClientType clientType = parseClientClassification(clientClassificationString);

        String datesString = string.substring(string.indexOf(':') + 1).trim();
        List<LocalDate> dates = parseDates(datesString);

        return new InputWrapper(dates, clientType);

    }

    private static ClientType parseClientClassification(String clientClassificationString) throws RuntimeException {
        return ClientType.valueOf(clientClassificationString);
    }

    private static List<LocalDate> parseDates(String string) throws RuntimeException {
        List<String> stringDates = Arrays.asList(string.split("\\s*,\\s*"));
        return stringDates.stream()
                .map(InputParser::parseDate)
                .collect(Collectors.toList());
    }

    private static LocalDate parseDate(final String dateString) throws RuntimeException {
        String adequatedDateString = adequateToFormatter(dateString);
        return LocalDate.parse(adequatedDateString, dateFormatter);
    }

    private static String adequateToFormatter(final String string) throws RuntimeException {

        String dateString = string.substring(0,10);
        String weekDayString = string.substring(10).toLowerCase();
        weekDayString = weekDayString.substring(0, 1).toUpperCase() + weekDayString.substring(1).toLowerCase();

        if(weekDayString.length() > 4) {
            StringBuilder stringBuilder = new StringBuilder(weekDayString);
            stringBuilder.deleteCharAt(3);
            weekDayString = stringBuilder.toString();
        }

        return dateString + weekDayString;
    }

}