package fr.flight_tracking.flight_manager.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link fr.flight_tracking.flight_manager.model.flight.Flight}
 */
public record CreateFlightInput(
        @NotNull
        @NotEmpty
        @NotBlank
        String flightNumber,
        @Size(message = "Icao require four alphanum symbol", min = 4, max = 4)
        String aircraftIcao,
        @Size(message = "Icao require four alphanum symbol", min = 4, max = 4)
        String departureIcao,

        @Size(message = "Icao require four alphanum symbol", min = 4, max = 4)
        String arrivalIcao,
        @Positive(message = "Cruise level can't be negative")
        @Range(message = "Cruise level should be between 1000ft and 100000ft", min = 1000, max = 100000)
        int cruiseLevel,
        LocalDateTime expectedDepartureTime,
        LocalDateTime expectedArrivalTime,
        String pilotName
) implements Serializable {
}