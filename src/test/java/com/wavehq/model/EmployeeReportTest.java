package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class EmployeeReportTest {
    @Test
    void testSetAmountPaid() {
        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setAmountPaid(10.0d);
        assertEquals("$10.00", employeeReport.getAmountPaid());
    }

    @Test
    void testSetAmountPaid2() {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);

        PayPeriod payPeriod = new PayPeriod();
        payPeriod.setFromDate(timestamp);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setToDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setPayPeriod(payPeriod);
        employeeReport.setAmountPaid(10.0d);
        verify(timestamp).getTime();
        assertEquals("$10.00", employeeReport.getAmountPaid());
    }

    @Test
    void testCheckEmployeeAndPayPeriod() {
        PayPeriod payPeriod = new PayPeriod();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setFromDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setToDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setAmountPaid(10.0d);
        employeeReport.setEmployeeId("42");
        employeeReport.setPayPeriod(payPeriod);

        PayPeriod payPeriod1 = new PayPeriod();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setFromDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setToDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport1 = new EmployeeReport();
        employeeReport1.setAmountPaid(10.0d);
        employeeReport1.setEmployeeId("42");
        employeeReport1.setPayPeriod(payPeriod1);
        assertTrue(EmployeeReport.checkEmployeeAndPayPeriod(employeeReport, employeeReport1));
    }

    @Test
    void testCheckEmployeeAndPayPeriod2() {
        PayPeriod payPeriod = new PayPeriod();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setFromDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setToDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setAmountPaid(10.0d);
        employeeReport.setEmployeeId("1969-12-31");
        employeeReport.setPayPeriod(payPeriod);

        PayPeriod payPeriod1 = new PayPeriod();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setFromDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setToDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport1 = new EmployeeReport();
        employeeReport1.setAmountPaid(10.0d);
        employeeReport1.setEmployeeId("42");
        employeeReport1.setPayPeriod(payPeriod1);
        assertFalse(EmployeeReport.checkEmployeeAndPayPeriod(employeeReport, employeeReport1));
    }

    @Test
    void testCheckEmployeeAndPayPeriod3() {
        PayPeriod payPeriod = new PayPeriod();
        LocalDateTime atStartOfDayResult = LocalDate.of(1, 1, 1).atStartOfDay();
        payPeriod.setFromDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setToDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setAmountPaid(10.0d);
        employeeReport.setEmployeeId("42");
        employeeReport.setPayPeriod(payPeriod);

        PayPeriod payPeriod1 = new PayPeriod();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setFromDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setToDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport1 = new EmployeeReport();
        employeeReport1.setAmountPaid(10.0d);
        employeeReport1.setEmployeeId("42");
        employeeReport1.setPayPeriod(payPeriod1);
        assertFalse(EmployeeReport.checkEmployeeAndPayPeriod(employeeReport, employeeReport1));
    }

    @Test
    void testCheckEmployeeAndPayPeriod4() {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);

        PayPeriod payPeriod = new PayPeriod();
        payPeriod.setFromDate(timestamp);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod.setToDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.setAmountPaid(10.0d);
        employeeReport.setEmployeeId("42");
        employeeReport.setPayPeriod(payPeriod);

        PayPeriod payPeriod1 = new PayPeriod();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setFromDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        payPeriod1.setToDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));

        EmployeeReport employeeReport1 = new EmployeeReport();
        employeeReport1.setAmountPaid(10.0d);
        employeeReport1.setEmployeeId("42");
        employeeReport1.setPayPeriod(payPeriod1);
        assertTrue(EmployeeReport.checkEmployeeAndPayPeriod(employeeReport, employeeReport1));
        verify(timestamp).getTime();
    }
}

