package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PayrollReportResponseTest {
    @Test
    void testConstructor() {
        PayrollReportResponse actualPayrollReportResponse = new PayrollReportResponse();
        PayrollReport payrollReport = new PayrollReport();
        payrollReport.setEmployeeReports(new ArrayList<>());
        actualPayrollReportResponse.setPayrollReport(payrollReport);
        assertSame(payrollReport, actualPayrollReportResponse.getPayrollReport());
    }
}

