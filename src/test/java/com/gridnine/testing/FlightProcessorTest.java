package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightProcessorTest {
    private List<Flight> flights;
    private FlightFilterProcessor processor;

    @BeforeEach
    public void setUp() {
        flights = FlightBuilder.createFlights();
        List<FlightFilter> filters = List.of(
                new DepartureBeforeNowFilter(),
                new ArrivalBeforeDepartureFilter(),
                new GroundTimeExceedsTwoHoursFilter()
        );
        processor = new FlightFilterProcessor(filters);
    }

    @Test
    public void testFilter() {
        List<Flight> filteredFlights = processor.filter(flights);

        assertEquals(2, filteredFlights.size());
    }
}
