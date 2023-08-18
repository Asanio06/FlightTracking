package fr.flight_tracking.aircraft_data_receiver.controller;

import fr.flight_tracking.aircraft_data_receiver.dto.AircraftStateInput;
import fr.flight_tracking.aircraft_data_receiver.mapper.AircraftStateInputMapper;
import fr.flight_tracking.aircraft_data_receiver.service.AircraftDataReceiverService;
import fr.flight_tracking.kafka.model.AircraftState;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aircraft-data-receiver")
public class AircraftDataReceiverController {

    private final AircraftDataReceiverService aircraftDataReceiverService;
    private final AircraftStateInputMapper aircraftStateInputMapper = Mappers.getMapper(AircraftStateInputMapper.class);
    ;


    @Autowired
    public AircraftDataReceiverController(AircraftDataReceiverService aircraftDataReceiverService) {
        this.aircraftDataReceiverService = aircraftDataReceiverService;
    }

    @PostMapping(value = "/{flightId}", consumes = "application/json")
    public void sendAircraftData(@PathVariable UUID flightId, @RequestBody AircraftStateInput aircraftStateInput) {
        // TODO: Communiquer avec le flight service pour vérifier l'existance du vol

        var aircraftState = aircraftStateInputMapper.toAircraftState(aircraftStateInput);
        aircraftDataReceiverService.sendAircraftData(flightId, aircraftState);
    }

}
