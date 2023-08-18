package fr.flight_tracking.aircraft_data_receiver.mapper;

import fr.flight_tracking.aircraft_data_receiver.dto.AircraftStateInput;
import fr.flight_tracking.kafka.model.AircraftState;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AircraftStateInputMapper {

    AircraftState toAircraftState(AircraftStateInput aircraftStateInput);

}
