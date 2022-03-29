package com.wavehq.controller;

import com.wavehq.model.*;
import com.wavehq.service.TimeReportInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@AllArgsConstructor
public class PayrollReportController {

    @Autowired
    TimeReportInfoService timeReportInfoService;

    @GetMapping("/payrollReport")
    public ResponseEntity<Object> getPayRollReport(){
        Iterable<TimeReportInfo> timeReportInfos = timeReportInfoService.findAll();
        PayrollReport payrollReport = new PayrollReport();
        PayrollReportResponse response = new PayrollReportResponse();
        List<EmployeeReport> employeeReports = new ArrayList<>();
        for(TimeReportInfo timeReportInfo : timeReportInfos){
            EmployeeReport employeeReport = new EmployeeReport();
            employeeReport.setEmployeeId(String.valueOf(timeReportInfo.getEmployeeId()));
            employeeReport.setPayPeriod(getPayPeriod(timeReportInfo.getDate()));
            employeeReport.setAmountPaid(JobGroup.valueOf(timeReportInfo.getJobGroup()).getPay() * timeReportInfo.getHoursWorked());
            employeeReports.add(employeeReport);
        }
        payrollReport.setEmployeeReports(combinePayPeriods(employeeReports));
        response.setPayrollReport(payrollReport);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private PayPeriod getPayPeriod(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        PayPeriod payPeriod = new PayPeriod();

        if (calendar.get(Calendar.DAY_OF_MONTH) <= 15){
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            payPeriod.setFromDate(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH, 15);
            payPeriod.setToDate(calendar.getTime());
            return payPeriod;
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, 16);
            payPeriod.setFromDate(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            payPeriod.setToDate(calendar.getTime());
            return payPeriod;
        }
    }

    private List<EmployeeReport> combinePayPeriods(List<EmployeeReport> employeeReports){
        int l = 0;
        while (l < employeeReports.size()) {
            int r = l + 1;
            while (r < employeeReports.size()) {
                if (EmployeeReport.checkEmployeeAndPayPeriod(employeeReports.get(l), employeeReports.get(r))) {
                    Double amountL = Double.valueOf(employeeReports.get(l).getAmountPaid().substring(1));
                    Double amountR = Double.valueOf(employeeReports.get(r).getAmountPaid().substring(1));
                    Double mergedAmount = amountL + amountR;
                    employeeReports.get(l).setAmountPaid(mergedAmount);
                    employeeReports.remove(r);
                } else {
                    r++;
                }
            }
            l++;
        }
        return employeeReports;
    }
}
