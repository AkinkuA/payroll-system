package com.wavehq.service;

import com.wavehq.model.TimeReport;
import com.wavehq.repo.TimeReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeReportService {
    @Autowired
    private TimeReportRepository timeReportRepository;

    public TimeReportService(TimeReportRepository timeReportRepository) {
        this.timeReportRepository = timeReportRepository;
    }

    public TimeReport save(TimeReport timeReport){
        return timeReportRepository.save(timeReport);
    }

}
