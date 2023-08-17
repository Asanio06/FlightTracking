package fr.flight_tracking.flight_manager.dto;

import fr.flight_tracking.flight_manager.model.flight.Flight;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Flight}
 */
public record CreateFlightResponse(UUID id) implements Serializable {
}