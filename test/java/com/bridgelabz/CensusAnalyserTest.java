package com.bridgelabz;

import com.bridgelabz.ReadOperations;
import com.bridgelabz.StateSensorAnalyserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CensusAnalyserTest {
    ReadOperations readObj = new ReadOperations();
    String fileName = "IndianStateCensusData";

    @Test
    public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() {
        String filePathRead = "C:\\Users\\hp\\IdeaProjects\\IndianCensus\\src\\main\\java\\com\\bridgelabz\\IndianStateCensusData";
        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(29, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException() {
        String filePathRead = ".src/main/java/com/bridgelabz/IndianStateCensusData";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(29, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException() {
        String filePathRead = "./src/main/java/com/bridgelabz/IndianStateCensusData.pdf";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(29, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "./src/main/java/com/bridgelabz/IndianStateCensusData.csv";
        String delimiter = ".";
        try {
            if (delimiter.equals(","))
                Assertions.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
            else
                Assertions.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThrowException() {
        List<String> stringName = new ArrayList<>();
        String filePathRead = "./src/main/java/com/bridgelabz/IndianStateCensusData.csv";
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("Density");

        try {
            boolean flag = readObj.readHeader(filePathRead, stringName);
            if (flag)
                Assertions.assertTrue(flag);
            else
                Assertions.assertFalse(flag);
        } catch (IOException | StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

}
