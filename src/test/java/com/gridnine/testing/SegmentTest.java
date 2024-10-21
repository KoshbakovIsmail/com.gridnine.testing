package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SegmentTest {

    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Segment segment;

    @BeforeEach
    public void setUp() {
        departureDate = LocalDateTime.now();
        arrivalDate = departureDate.plusHours(2);
        segment = new Segment(departureDate, arrivalDate);
    }

    @Test
    public void testGetDepartureDate() {
        assertEquals(departureDate, segment.getDepartureDate());
    }

    @Test
    public void testGetArrivalDate() {
        assertEquals(arrivalDate, segment.getArrivalDate());
    }

    @Test
    public void testToString() {
        String expected = "[" + departureDate + " - " + arrivalDate + "]";
        assertEquals(expected, segment.toString());
    }

    @Test
    public void testNullDepartureDate() {
        assertThrows(NullPointerException.class, () -> {
            new Segment(null, arrivalDate);
        });
    }

    @Test
    public void testNullArrivalDate() {
        assertThrows(NullPointerException.class, () -> {
            new Segment(departureDate, null);
        });
    }
}
