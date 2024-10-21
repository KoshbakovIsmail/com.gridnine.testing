package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlightBuilderTest {
    private List<Flight> flights;

    @BeforeEach
    public void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    public void testCreateFlights() {
        assertEquals(6, flights.size());
    }

    @Test
    public void testCreateFlightWithOddNumberOfDates() {
        assertThrows(IllegalArgumentException.class, () -> {
            FlightBuilder.createFlight(LocalDateTime.now());
        });
    }
}
