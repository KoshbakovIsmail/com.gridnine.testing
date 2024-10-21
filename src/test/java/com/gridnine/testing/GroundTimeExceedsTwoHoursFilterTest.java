package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroundTimeExceedsTwoHoursFilterTest {

    private List<Flight> flights;
    private FlightFilter filter;

    @BeforeEach
    public void setUp() {
        flights = FlightBuilder.createFlights();
        filter = new GroundTimeExceedsTwoHoursFilter();
    }

    @Test
    public void testFilter() {
            List<Flight> filteredFlights = filter.filter(flights);

            // Пересчитаем количество рейсов, которые должны остаться
            long expectedCount = flights.stream()
                    .filter(flight -> {
                        List<Segment> segments = flight.getSegments();
                        long totalGroundTime = 0;

                        for (int i = 0; i < segments.size() - 1; i++) {
                            Segment currentSegment = segments.get(i);
                            Segment nextSegment = segments.get(i + 1);
                            totalGroundTime += Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()).toMinutes();
                        }

                        return totalGroundTime <= 120; // 120 минут = 2 часа
                    })
                    .count();

            // Выводим отладочную информацию
            System.out.println("All flights:");
            flights.forEach(System.out::println);

            System.out.println("\nFiltered flights:");
            filteredFlights.forEach(System.out::println);
            assertEquals(expectedCount, filteredFlights.size());
    }
}
