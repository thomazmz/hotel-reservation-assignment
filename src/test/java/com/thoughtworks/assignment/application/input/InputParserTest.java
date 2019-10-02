package com.thoughtworks.assignment.application.input;

import com.thoughtworks.assignment.domain.price.ClientType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputParserTest {

    static InputParser parser;

    @BeforeAll
    static void injectParser() {
        parser = new InputParser();
    }

    static Stream<Arguments> getInputStringList() {

        ClientType rewardsClientType = ClientType.REWARDS;
        ClientType regularClientType = ClientType.REGULAR;

        List<LocalDate> firstDateList = new ArrayList<>();
        firstDateList.add(LocalDate.of(2009, Month.MARCH, 16));
        firstDateList.add(LocalDate.of(2009, Month.MARCH, 17));
        firstDateList.add(LocalDate.of(2009, Month.MARCH, 18));

        List<LocalDate> secondDateList = new ArrayList<>();
        secondDateList.add(LocalDate.of(2009, Month.MARCH, 20));
        secondDateList.add(LocalDate.of(2009, Month.MARCH, 21));
        secondDateList.add(LocalDate.of(2009, Month.MARCH, 22));

        List<LocalDate> thirdDateList = new ArrayList<>();
        thirdDateList.add(LocalDate.of(2009, Month.MARCH, 26));
        thirdDateList.add(LocalDate.of(2009, Month.MARCH, 27));
        thirdDateList.add(LocalDate.of(2009, Month.MARCH, 28));

        return Stream.of(
                Arguments.of("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)", regularClientType, firstDateList),
                Arguments.of("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)", regularClientType, secondDateList),
                Arguments.of("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)", rewardsClientType, thirdDateList)
        );
    }

    @ParameterizedTest()
    @MethodSource("getInputStringList")
    void shouldReturnClientClassification(String inputString, ClientType clientType, List<LocalDate> dates) throws Exception {
        // When
        InputWrapper inputWrapper = parser.parse(inputString);
        // Then
        assertEquals(inputWrapper.getClientType(), clientType);
        assertTrue(inputWrapper.getDates().containsAll(dates));
    }
}