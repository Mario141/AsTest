package com.example.actest;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * a uutil class class for processing the source csv file
 * @author Renhao Zheng
 */
@Component
public class CsvUtil {

    public List<String[]> readCsvFile(File file) throws IOException, CsvException {

        CSVReader csvReader = new CSVReader(new FileReader(file));
        List<String[]> list = csvReader.readAll();
        list = formatData(list);
        return list;
    }

    /**
     * the method for processing a source csv file which isn't regular
     * @param list
     * @return a list includes 4 attribute each line
     */
    public List<String[]> formatData(List<String[]> list) {

        List<String> processedList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            processedList.addAll(Arrays.asList(list.get(i)));
        }
        processedList.remove(" ");
        processedList.remove("");
        Object[] array = processedList.toArray();
        List<String[]> newList = new ArrayList<>();

        for (int i=0; i<processedList.size(); i=i+4) {
            String[] a = new String[4];
            int j=0;
            a[j] = processedList.get(i);
            a[j+1] = processedList.get(i+1);
            a[j+2] = processedList.get(i+2);
            a[j+3] = processedList.get(i+3);
            newList.add(a);
            a=null;
        }

        return newList;

    }

}
