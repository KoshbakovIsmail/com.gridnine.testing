package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Objects;

public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "[" + departureDate + " - " + arrivalDate + "]";
    }
}
