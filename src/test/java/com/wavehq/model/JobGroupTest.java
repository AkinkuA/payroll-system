package com.wavehq.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JobGroupTest {
    @Test
    void testValueOf() {
        JobGroup actualValueOfResult = JobGroup.valueOf("A");
        assertEquals("A", actualValueOfResult.getGroup());
        assertEquals(20.0d, actualValueOfResult.getPay().doubleValue());
    }
}

