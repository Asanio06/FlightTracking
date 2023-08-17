package fr.flight_tracking.flight_manager.controller;


import fr.flight_tracking.flight_manager.dto.CreateFlightInput;
import fr.flight_tracking.flight_manager.dto.CreateFlightResponse;
import fr.flight_tracking.flight_manager.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/flight")
public class ManageFlightController {

    private final FlightService flightService;

    public ManageFlightController(FlightService flightService) {
        this.flightService = flightService;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateFlightResponse> beginFlight(@Valid @RequestBody CreateFlightInput flightInputDto) {

        var createdFlight = flightService.beginFlight(flightInputDto.flightNumber(), flightInputDto.aircraftIcao(), flightInputDto.departureIcao(), flightInputDto.arrivalIcao(), flightInputDto.cruiseLevel(), flightInputDto.expectedDepartureTime(), flightInputDto.expectedArrivalTime(), flightInputDto.pilotName());

        return ResponseEntity.ok(new CreateFlightResponse(createdFlight.getId()));

    }


    @PutMapping("/{flightId}/close")
    public void closeFlight(@PathVariable("flightId") UUID flightId) {
        flightService.closeFlight(flightId);
    }

    @DeleteMapping("/{flightId}")
    public void deleteFlight(@PathVariable("flightId") UUID flightId) {
        flightService.deleteFlight(flightId);
    }


}
