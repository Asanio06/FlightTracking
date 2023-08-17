package fr.flight_tracking.flight_manager.model.flight;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

public enum FlightStatus {

    IN_PROGRESS("in_progress"),
    DELETED("deleted"),
    FINISHED("finished");

    private final String value;

    FlightStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FlightStatus fromValue(String value) {
        return Arrays.stream(values())
                .filter(flightStatus -> flightStatus.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("no flight statuts found for value " + value));
    }

    @Converter(autoApply = true)
    public static class FlightStatusConverter
            implements AttributeConverter<FlightStatus, String> {

        public String convertToDatabaseColumn(FlightStatus flightStatus) {
            if (flightStatus == null) {
                return null;
            }

            return flightStatus.getValue();
        }

        public FlightStatus convertToEntityAttribute(String value) {
            if (value == null) {
                return null;
            }

            return FlightStatus.fromValue(value);
        }
    }

}
