package com.wavehq.controller;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.wavehq.model.TimeReport;
import com.wavehq.model.TimeReportInfo;
import com.wavehq.service.TimeReportInfoService;
import com.wavehq.service.TimeReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class FileUploadController {

    @Autowired
    TimeReportInfoService timeReportInfoService;

    @Autowired
    TimeReportService timeReportService;

    @PostMapping("/uploadTimesheet")
    public ResponseEntity<Object> fileUpload(@RequestParam("File")MultipartFile file) {

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName(file.getOriginalFilename());
        if (Objects.equals(file.getOriginalFilename(), "")){
            return new ResponseEntity<>("No filename detected", HttpStatus.BAD_REQUEST);
        }

        List<TimeReportInfo> timeReports = new ArrayList<>();
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("There was a problem reading the file; please try again", HttpStatus.BAD_REQUEST);
        }

        try {
            timeReportService.save(timeReport);
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return new ResponseEntity<>("File has been uploaded previously; please try another file", HttpStatus.BAD_REQUEST);
        }

        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setHeaderExtractionEnabled(true);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<Record> records = csvParser.parseAllRecords(inputStream);
        for (Record currentRecord : records){
            TimeReportInfo employeeReport = new TimeReportInfo();
            employeeReport.setEmployeeId(currentRecord.getInt("employee id"));
            try {
                employeeReport.setDate(new SimpleDateFormat("dd/MM/yyy").parse(currentRecord.getString("date")));
            } catch (ParseException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Format of date in file is incorrect", HttpStatus.BAD_REQUEST);
            }
            employeeReport.setHoursWorked(currentRecord.getDouble("hours worked"));
            employeeReport.setJobGroup(currentRecord.getString("job group"));
            timeReports.add(employeeReport);
        }
        try {
            timeReportInfoService.saveAll(timeReports);
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return new ResponseEntity<>("Information in file has been previously uploaded; fix file and try again", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("The file was uploaded successfully", HttpStatus.OK);
    }
}
