package com.wavehq.service;

import com.wavehq.model.TimeReportInfo;
import com.wavehq.repo.TimeReportInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TimeReportInfoService.class})
@ExtendWith(MockitoExtension.class)
class TimeReportInfoServiceTest {


    @Mock
    private TimeReportInfoRepository timeReportInfoRepository;
    private TimeReportInfoService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TimeReportInfoService(timeReportInfoRepository);
    }

    @Test
    void testSaveAll() {
        TimeReportInfo timeReportInfo = new TimeReportInfo();
        List<TimeReportInfo> timeReportInfos = new ArrayList<>();
        timeReportInfos.add(timeReportInfo);
        underTest.saveAll(timeReportInfos);
        ArgumentCaptor<List<TimeReportInfo>> timeReportInfosArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(timeReportInfoRepository).saveAll(timeReportInfosArgumentCaptor.capture());
        List<TimeReportInfo> capturedValue = timeReportInfosArgumentCaptor.getValue();
        assertThat(capturedValue).isEqualTo(timeReportInfos);
    }

    @Test
    void testFindAll() {
        when(timeReportInfoRepository.findAll()).thenReturn((Iterable<TimeReportInfo>) mock(Iterable.class));
        underTest.findAll();
        verify(timeReportInfoRepository).findAll();
    }

}