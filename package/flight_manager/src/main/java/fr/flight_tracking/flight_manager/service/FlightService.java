package fr.flight_tracking.flight_manager.service;

import fr.flight_tracking.flight_manager.exception.FlightException;
import fr.flight_tracking.flight_manager.model.flight.Flight;
import fr.flight_tracking.flight_manager.model.flight.FlightStatus;
import fr.flight_tracking.flight_manager.repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

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
        flight.setStatus(FlightStatus.IN_PROGRESS);

        return flightRepository.save(flight);
    }

    public void closeFlight(UUID flightId) {
        var flight = flightRepository.findById(flightId).orElseThrow(() -> new FlightException.FlightNotFoundException(flightId));

        if (flight.getStatus().equals(FlightStatus.FINISHED)) {
            throw new FlightException.FlightAlreadyClosedException(flightId);
        }

        flight.setStatus(FlightStatus.FINISHED);

        flightRepository.save(flight);
    }

    public void deleteFlight(UUID flightId){
        var flight = flightRepository.findById(flightId).orElseThrow(() -> new FlightException.FlightNotFoundException(flightId));

        flightRepository.delete(flight);

    }
}
