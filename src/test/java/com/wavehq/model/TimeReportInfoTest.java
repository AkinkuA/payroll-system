package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TimeReportInfoTest {
    @Test
    void testConstructor() {
        TimeReportInfo actualTimeReportInfo = new TimeReportInfo();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualTimeReportInfo.setDate(fromResult);
        actualTimeReportInfo.setEmployeeId(123);
        actualTimeReportInfo.setHoursWorked(10.0d);
        actualTimeReportInfo.setId(1);
        actualTimeReportInfo.setJobGroup("Job Group");
        assertSame(fromResult, actualTimeReportInfo.getDate());
        assertEquals(123, actualTimeReportInfo.getEmployeeId().intValue());
        assertEquals(10.0d, actualTimeReportInfo.getHoursWorked().doubleValue());
        assertEquals(1, actualTimeReportInfo.getId().intValue());
        assertEquals("Job Group", actualTimeReportInfo.getJobGroup());
    }
}

