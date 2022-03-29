package com.wavehq.model;

import java.util.List;

public class PayrollReport {
    private List<EmployeeReport> employeeReports;

    public List<EmployeeReport> getEmployeeReports() {
        return employeeReports;
    }

    public void setEmployeeReports(List<EmployeeReport> employeeReports) {
        this.employeeReports = employeeReports;
    }
}
