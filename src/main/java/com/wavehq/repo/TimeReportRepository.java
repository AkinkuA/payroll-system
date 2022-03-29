package com.wavehq.repo;

import com.wavehq.model.TimeReport;
import org.springframework.data.repository.CrudRepository;

public interface TimeReportRepository extends CrudRepository<TimeReport, Integer> {
}
