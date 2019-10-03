package com.thoughtworks.assignment.application.input;

import java.io.IOException;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputFileReader {

    private static final String inputFilePath = "/Users/Thomazmz/Desktop/assignment/hotel-reservation-assignment-maven/input";

    public static List<String> readInputs() throws IOException {
        Scanner scanner = new Scanner(new File(inputFilePath));
        scanner.useDelimiter(System.lineSeparator());
        LinkedList<String> list = new LinkedList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        return list;
    }
}
