package com.gridnine.testing;

import java.util.List;

public class FlightFilterProcessor {
    private final List<FlightFilter> filters;

    public FlightFilterProcessor(List<FlightFilter> filters) {
        this.filters = filters;
    }

    public List<Flight> filter(List<Flight> flights) {
        for (FlightFilter filter : filters) {
            flights = filter.filter(flights);
        }
        return flights;
    }
}
