package com.thoughtworks.assignment.application.input;

import java.io.FileNotFoundException;
import java.io.File;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public static List<String> readInputs(String filePath) throws FileNotFoundException {
        String fileAbsolutePath = Paths.get("").toAbsolutePath().toString() + filePath;
        Scanner scanner = new Scanner(new File(fileAbsolutePath));
        scanner.useDelimiter(System.lineSeparator());
        LinkedList<String> list = new LinkedList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        return list;
    }
}
