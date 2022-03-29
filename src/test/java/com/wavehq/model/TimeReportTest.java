package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TimeReportTest {
    @Test
    void testConstructor() {
        TimeReport actualTimeReport = new TimeReport();
        actualTimeReport.setFileName("foo.txt");
        assertEquals("foo.txt", actualTimeReport.getFileName());
        assertNull(actualTimeReport.getId());
    }
}

