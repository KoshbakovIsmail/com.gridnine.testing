package com.gridnine.testing;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		List<Flight> flights = FlightBuilder.createFlights();

		System.out.println("All flights:");
		flights.forEach(System.out::println);

		FlightFilter departureBeforeNowFilter = new DepartureBeforeNowFilter();
		List<Flight> filteredByDepartureBeforeNow = departureBeforeNowFilter.filter(flights);
		System.out.println("\nFlights with departure before now:");
		filteredByDepartureBeforeNow.forEach(System.out::println);

		FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
		List<Flight> filteredByArrivalBeforeDeparture = arrivalBeforeDepartureFilter.filter(flights);
		System.out.println("\nFlights with arrival before departure:");
		filteredByArrivalBeforeDeparture.forEach(System.out::println);

		FlightFilter groundTimeExceedsTwoHoursFilter = new GroundTimeExceedsTwoHoursFilter();
		List<Flight> filteredByGroundTimeExceedsTwoHours = groundTimeExceedsTwoHoursFilter.filter(flights);
		System.out.println("\nFlights with ground time exceeding two hours:");
		filteredByGroundTimeExceedsTwoHours.forEach(System.out::println);

		List<FlightFilter> filters = Arrays.asList(
				new DepartureBeforeNowFilter(),
				new ArrivalBeforeDepartureFilter(),
				new GroundTimeExceedsTwoHoursFilter()
		);
		FlightFilterProcessor processor = new FlightFilterProcessor(filters);
		List<Flight> fullyFilteredFlights = processor.filter(flights);
		System.out.println("\nFlights after applying all filters");
		fullyFilteredFlights.forEach(System.out::println);
	}

}
