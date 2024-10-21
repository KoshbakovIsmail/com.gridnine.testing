package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrivalBeforeDepartureFilterTest {
    private List<Flight> flights;
    private FlightFilter filter;

    @BeforeEach
    public void setUp() {
        flights = FlightBuilder.createFlights();
        filter = new DepartureBeforeNowFilter();
    }

    @Test
    public void testFilter() {
        List<Flight> filteredFlights = filter.filter(flights);
        assertTrue(filteredFlights.stream()
                .allMatch(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))));
    }
}
