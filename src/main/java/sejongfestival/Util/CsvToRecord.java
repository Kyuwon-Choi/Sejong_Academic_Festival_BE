package sejongfestival.Util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import sejongfestival.Model.RecordCsv;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToRecord {
    public static List<RecordCsv> readAndSaveWordData(String filePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<RecordCsv> records = new ArrayList<>();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 3) {
                    RecordCsv record = new RecordCsv(nextLine[0],nextLine[1],nextLine[2]);
                    records.add(record);
                }
            }
            return records;
        } catch (CsvValidationException e) {
            throw new IOException(e);
        }
    }
}
