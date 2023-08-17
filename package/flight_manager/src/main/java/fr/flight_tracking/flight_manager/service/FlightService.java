package fr.flight_tracking.flight_manager.service;

import fr.flight_tracking.flight_manager.model.flight.Flight;
import fr.flight_tracking.flight_manager.repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }



    @Transactional()
    public Flight beginFlight(String flightNumber,
                              String aircraftIcao,
                              String departureIcao,
                              String arrivalIcao,
                              int cruiseLevel,
                              LocalDateTime expectedDepartureTime,
                              LocalDateTime expectedArrivalTime,
                              String pilotName) {


        var flight = new Flight();
        flight.setFlightNumber(flightNumber);
        flight.setAircraftIcao(aircraftIcao);
        flight.setDepartureIcao(departureIcao);
        flight.setArrivalIcao(arrivalIcao);
        flight.setCruiseLevel(cruiseLevel);
        flight.setExpectedDepartureTime(expectedDepartureTime);
        flight.setExpectedArrivalTime(expectedArrivalTime);
        flight.setPilotName(pilotName);

        return flightRepository.save(flight);
    }
}
