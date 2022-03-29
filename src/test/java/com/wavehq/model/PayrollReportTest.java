package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PayrollReportTest {
    @Test
    void testConstructor() {
        PayrollReport actualPayrollReport = new PayrollReport();
        ArrayList<EmployeeReport> employeeReportList = new ArrayList<>();
        actualPayrollReport.setEmployeeReports(employeeReportList);
        assertSame(employeeReportList, actualPayrollReport.getEmployeeReports());
    }
}

