package sejongfestival.Controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sejongfestival.Model.FilePath;
import sejongfestival.Model.RecordCsv;
import sejongfestival.Repository.RecordRepository;
import sejongfestival.service.CsvService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CsvController {

    private final CsvService csvService;
    private final RecordRepository recordRepository;

    @PostMapping("/csv/upload")
    public ResponseEntity<String> uploadFile(@RequestBody FilePath filePath) {
        try {
            csvService.readAndSaveCsvData(filePath.getFilePath());
            return ResponseEntity.ok("File uploaded and data saved successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to process file: " + e.getMessage());
        }
    }

//    @GetMapping("/ideas")
//    public List<RecordCsv> getAllIdeas() {
//        return recordRepository.findAll();
//    }

    @GetMapping("/ideas")
    public List<RecordCsv> getAllIdeas() {
        // 최대 100개의 데이터만 반환
        return recordRepository.findAll().stream().limit(100).collect(Collectors.toList());
    }
}