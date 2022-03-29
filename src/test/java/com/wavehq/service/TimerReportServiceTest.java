package com.wavehq.service;

import com.wavehq.model.TimeReport;
import com.wavehq.repo.TimeReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TimerReportServiceTest {

    @Mock
    private TimeReportRepository timeReportRepository;
    private TimeReportService underTest;


    @BeforeEach
    void setUp(){
        underTest = new TimeReportService(timeReportRepository);
    }

    @Test
    void testSave() {
        TimeReport timeReport = new TimeReport();
        underTest.save(timeReport);
        ArgumentCaptor<TimeReport> timeReportArgumentCaptor = ArgumentCaptor.forClass(TimeReport.class);
        verify(timeReportRepository).save(timeReportArgumentCaptor.capture());
        TimeReport capturedTimeReport = timeReportArgumentCaptor.getValue();
        assertThat(capturedTimeReport).isEqualTo(timeReport);
    }
}