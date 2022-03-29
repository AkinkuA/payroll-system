package com.wavehq.service;

import com.wavehq.model.TimeReportInfo;
import com.wavehq.repo.TimeReportInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeReportInfoService {

    @Autowired
    TimeReportInfoRepository timeReportInfoRepository;

    public TimeReportInfoService(TimeReportInfoRepository timeReportInfoRepository) {
        this.timeReportInfoRepository = timeReportInfoRepository;
    }

    public Iterable<TimeReportInfo> saveAll(List<TimeReportInfo> timeReports){
        return timeReportInfoRepository.saveAll(timeReports);
    }

    public Iterable<TimeReportInfo> findAll() {
        return timeReportInfoRepository.findAll();
    }
}
