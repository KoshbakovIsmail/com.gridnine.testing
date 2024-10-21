package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    private LocalDateTime now;
    private List<Segment> segments;
    private Flight flight;

    @BeforeEach
    public void setUp() {
        now = LocalDateTime.now();
        segments = Arrays.asList(
                new Segment(now, now.plusHours(2)),
                new Segment(now.plusHours(3), now.plusHours(5))
        );
        flight = new Flight(segments);
    }

    @Test
    public void testGetSegments() {
        assertEquals(segments, flight.getSegments());
    }

    @Test
    public void testToString() {
        String expected = segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        assertEquals(expected, flight.toString());
    }
}
