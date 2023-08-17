package fr.flight_tracking.flight_manager.model.flight;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

public enum FlightStep {

    NONE("none"),
    GROUNG("ground"),
    BOARDING("boarding"),
    PUSHBACK("pushback"),
    BLOCK_ON("block_on"),
    TAXI_OUT("taxi_out"),
    TAKEOFF("takeoff"),
    INITIAL_CLIMB("initial_climb"),
    CLIMB("climb"),
    CRUISE("cruise"),
    DESCENT("descent"),
    APPROACH("approach"),
    LANDING("landing"),
    TAXI_IN("taxi_in"),
    BLOCK_OFF("block_off"),
    DEBOARDING("deboarding"),
    PARKED("parked"),
    EMERGENCY("emergency"),
    CRASHED("crashed"),
    DIVERSION("diversion");

    private final String value;

    FlightStep(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FlightStep fromValue(String value) {
        return Arrays.stream(values())
                .filter(flightStep -> flightStep.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("no flight step found for value " + value));
    }


    @Converter(autoApply = true)
    public static class FlightStepConverter
            implements AttributeConverter<FlightStep, String> {

        public String convertToDatabaseColumn(FlightStep flightStep) {
            if (flightStep == null) {
                return null;
            }

            return flightStep.getValue();
        }

        public FlightStep convertToEntityAttribute(String value) {
            if (value == null) {
                return null;
            }

            return FlightStep.fromValue(value);
        }
    }
}
