package fr.flight_tracking.flight_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class FlightException extends RuntimeException {

    private FlightException(String message) {
        super(message);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class FlightNotFoundException extends FlightException {
        public FlightNotFoundException(UUID flightId) {
            super("Flight with id=" + flightId.toString() + " not found");
        }
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    public static class FlightAlreadyClosedException extends FlightException {
        public FlightAlreadyClosedException(UUID flightId) {
            super("Flight with id=" + flightId.toString() + " is already closed");
        }
    }
}
