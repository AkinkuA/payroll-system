package com.wavehq.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.wavehq.model.TimeReport;
import com.wavehq.model.TimeReportInfo;
import com.wavehq.repo.TimeReportInfoRepository;
import com.wavehq.repo.TimeReportRepository;
import com.wavehq.service.TimeReportInfoService;
import com.wavehq.service.TimeReportService;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

class FileUploadControllerTest {
    @Test
    void testFileUpload() throws UnsupportedEncodingException {
        TimeReportInfoService timeReportInfoService = new TimeReportInfoService(mock(TimeReportInfoRepository.class));
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService,
                new TimeReportService(mock(TimeReportRepository.class)));
        ResponseEntity<Object> actualFileUploadResult = fileUploadController
                .fileUpload(new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")));
        assertEquals("No filename detected", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
    }

    @Test
    void testFileUpload2() throws IOException {
        TimeReportInfoRepository timeReportInfoRepository = mock(TimeReportInfoRepository.class);
        when(timeReportInfoRepository.saveAll((Iterable<TimeReportInfo>) any()))
                .thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));
        TimeReportInfoService timeReportInfoService = new TimeReportInfoService(timeReportInfoRepository);

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName("foo.txt");
        TimeReportRepository timeReportRepository = mock(TimeReportRepository.class);
        when(timeReportRepository.save((TimeReport) any())).thenReturn(timeReport);
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService,
                new TimeReportService(timeReportRepository));
        ResponseEntity<Object> actualFileUploadResult = fileUploadController.fileUpload(new MockMultipartFile(
                "No filename detected", "foo.txt", "text/plain", new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8"))));
        assertEquals("The file was uploaded successfully", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.OK, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
        verify(timeReportInfoRepository).saveAll((Iterable<TimeReportInfo>) any());
        verify(timeReportRepository).save((TimeReport) any());
    }


    @Test
    void testFileUpload3() throws IOException {
        TimeReportInfoService timeReportInfoService = mock(TimeReportInfoService.class);
        when(timeReportInfoService.saveAll((java.util.List<TimeReportInfo>) any()))
                .thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName("foo.txt");
        TimeReportRepository timeReportRepository = mock(TimeReportRepository.class);
        when(timeReportRepository.save((TimeReport) any())).thenReturn(timeReport);
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService,
                new TimeReportService(timeReportRepository));
        ResponseEntity<Object> actualFileUploadResult = fileUploadController.fileUpload(new MockMultipartFile(
                "No filename detected", "foo.txt", "text/plain", new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8"))));
        assertEquals("The file was uploaded successfully", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.OK, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
        verify(timeReportInfoService).saveAll((java.util.List<TimeReportInfo>) any());
        verify(timeReportRepository).save((TimeReport) any());
    }

    @Test
    void testFileUpload4() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @14dd9eb7
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        TimeReportInfoService timeReportInfoService = mock(TimeReportInfoService.class);
        when(timeReportInfoService.saveAll((java.util.List<TimeReportInfo>) any()))
                .thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName("foo.txt");
        TimeReportService timerReportService = mock(TimeReportService.class);
        when(timerReportService.save((TimeReport) any())).thenReturn(timeReport);
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService, timerReportService);
        ResponseEntity<Object> actualFileUploadResult = fileUploadController.fileUpload(new MockMultipartFile(
                "No filename detected", "foo.txt", "text/plain", new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8"))));
        assertEquals("The file was uploaded successfully", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.OK, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
        verify(timeReportInfoService).saveAll((java.util.List<TimeReportInfo>) any());
        verify(timerReportService).save((TimeReport) any());
    }

    @Test
    void testFileUpload5() throws IOException {
        TimeReportInfoService timeReportInfoService = mock(TimeReportInfoService.class);
        when(timeReportInfoService.saveAll((java.util.List<TimeReportInfo>) any()))
                .thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName("foo.txt");
        TimeReportService timerReportService = mock(TimeReportService.class);
        when(timerReportService.save((TimeReport) any())).thenReturn(timeReport);
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService, timerReportService);
        ResponseEntity<Object> actualFileUploadResult = fileUploadController
                .fileUpload(new MockMultipartFile("No filename detected", "foo.txt", "text/plain",
                        new ByteArrayInputStream(new byte[]{1, 'A', 'A', 'A', 'A', 'A', 'A', 'A'})));
        assertEquals("The file was uploaded successfully", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.OK, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
        verify(timeReportInfoService).saveAll((java.util.List<TimeReportInfo>) any());
        verify(timerReportService).save((TimeReport) any());
    }

    @Test
    void testFileUpload6() throws IOException {
        TimeReportInfoService timeReportInfoService = mock(TimeReportInfoService.class);
        when(timeReportInfoService.saveAll((java.util.List<TimeReportInfo>) any()))
                .thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName("foo.txt");
        TimeReportService timerReportService = mock(TimeReportService.class);
        when(timerReportService.save((TimeReport) any())).thenReturn(timeReport);
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService, timerReportService);
        ResponseEntity<Object> actualFileUploadResult = fileUploadController
                .fileUpload(new MockMultipartFile("No filename detected", "foo.txt", "text/plain",
                        new ByteArrayInputStream(new byte[]{0, 'A', 'A', 'A', 'A', 'A', 'A', 'A'})));
        assertEquals("The file was uploaded successfully", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.OK, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
        verify(timeReportInfoService).saveAll((java.util.List<TimeReportInfo>) any());
        verify(timerReportService).save((TimeReport) any());
    }

    @Test
    void testFileUpload7() throws IOException {
        TimeReportInfoService timeReportInfoService = mock(TimeReportInfoService.class);
        when(timeReportInfoService.saveAll((java.util.List<TimeReportInfo>) any()))
                .thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));

        TimeReport timeReport = new TimeReport();
        timeReport.setFileName("foo.txt");
        TimeReportService timerReportService = mock(TimeReportService.class);
        when(timerReportService.save((TimeReport) any())).thenReturn(timeReport);
        FileUploadController fileUploadController = new FileUploadController(timeReportInfoService, timerReportService);
        ResponseEntity<Object> actualFileUploadResult = fileUploadController.fileUpload(
                new MockMultipartFile("No filename detected", "foo.txt", "text/plain", new ByteArrayInputStream(new byte[]{})));
        assertEquals("The file was uploaded successfully", actualFileUploadResult.getBody());
        assertEquals(HttpStatus.OK, actualFileUploadResult.getStatusCode());
        assertTrue(actualFileUploadResult.getHeaders().isEmpty());
        verify(timeReportInfoService).saveAll((java.util.List<TimeReportInfo>) any());
        verify(timerReportService).save((TimeReport) any());
    }
}

