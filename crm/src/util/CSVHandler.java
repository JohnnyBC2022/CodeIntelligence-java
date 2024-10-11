package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVHandler {
    protected abstract T parseLine (String line);
    protected abstract String toLine(T item);

    public List<T>readCSV(String filePath) throws IOException {
        List<T> items = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                items.add(parseLine(line));
            }
        }
        return items;
    }

    public void writeCSV(String filePath, List<T> items) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileWriter(filePath))) {
            for (T item : items) {
                bufferedReader.write(toLine(item));
                bufferedReader.newLine();
            }
        }
    }

}
