package com.bhavit.csvreadwrite.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * class that reads records from CSV file. and save to another CSV file.
 */
public class CsvHandler {
    private CsvHandler(){}

    /**
     * read data from input csv file and write it to output csv file
     */
    public static void csvReadWrite(){
        String inputFilePath = "src/main/resources/input.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                for (String s : line.split(",")) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

            reader.close();
            System.out.println("CSV file reading complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
