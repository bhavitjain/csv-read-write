package com.bhavit.csvreadwrite.util;

import com.bhavit.csvreadwrite.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * class that reads records from CSV file. and save to another CSV file.
 */
public class CsvHandler {    
    private static final Logger log = LoggerFactory.getLogger(CsvHandler.class);

    private CsvHandler(){}

    /**
     * read data from input csv file and write it to output csv file
     */
    public static void csvReadWrite(){

        String inputFilePath = Constants.INPUT_FILE_PATH;
        String outputFilePath = Constants.OUTPUT_FILE_PATH;

        System.out.println("inputFilePath");

        try {
            File outputFile = createOutputFile(outputFilePath);

            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
            log.info("CSV file reading and writing complete.");

        } catch (IOException e) {
            log.error("IOException thrown with message {}", e.getMessage());
        }
    }

    /**
     *
     * creates a new output file
     * @param outputFilePath output file path
     * @return output file
     * @throws IOException when we are unable to create new output file
     */
    private static File createOutputFile(String outputFilePath) throws IOException {

        File outputFile = new File(outputFilePath);
        if (!outputFile.canExecute()){
            outputFile.setExecutable(true);
        }
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();
        outputFile.setExecutable(true);

        return outputFile;
    }
}
