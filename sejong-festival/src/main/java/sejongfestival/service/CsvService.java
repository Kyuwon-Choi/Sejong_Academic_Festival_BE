package sejongfestival.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sejongfestival.Model.RecordCsv;
import sejongfestival.Repository.RecordRepository;
import sejongfestival.Util.CsvToRecord;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CsvService {

    private final RecordRepository recordRepository;

    public void readAndSaveCsvData(String filePath) throws IOException {
        List<RecordCsv> records = CsvToRecord.readAndSaveWordData(filePath);
        recordRepository.saveAll(records);
    }
}