package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PayPeriodTest {

    @Test
    void testSetFromDate2() {
        PayPeriod payPeriod = new PayPeriod();
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        payPeriod.setFromDate(timestamp);
        verify(timestamp).getTime();
    }


    @Test
    void testSetToDate2() {
        PayPeriod payPeriod = new PayPeriod();
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        payPeriod.setToDate(timestamp);
        verify(timestamp).getTime();
    }


    @Test
    void testConstructor() {
        PayPeriod actualPayPeriod = new PayPeriod();
        assertNull(actualPayPeriod.getFromDate());
        assertNull(actualPayPeriod.getToDate());
        assertTrue(actualPayPeriod.dateFormat.isLenient());
    }
}

