package com.thoughtworks.assignment;

import com.thoughtworks.assignment.application.hotel.HotelService;
import com.thoughtworks.assignment.application.input.InputReader;
import com.thoughtworks.assignment.application.input.InputWrapper;
import com.thoughtworks.assignment.domain.price.ClientType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static final String inputFilePath= "/input";

    public static final InputReader inputReader = new InputReader();

    public static final HotelService hotelService = new HotelService();

    public static void main(String[] args) {

        try {
            List<String> inputStrings = inputReader.readInputs(inputFilePath);
            inputStrings.forEach(inputString -> {
                try {
                    InputWrapper inputWrapper = InputWrapper.of(inputString);
                    ClientType clientType = inputWrapper.getClientType();
                    List<LocalDate> dates = inputWrapper.getDates();
                    System.out.println(hotelService.getCheapestHotel(clientType, dates).getName());
                } catch (Exception e) {
                    System.out.println("Invalid Input");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
