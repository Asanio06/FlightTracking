package fr.flight_tracking.flight_manager.model.flight;

public enum FlightStatus {

    IN_PROGRESS ("in_progress"),
    DELETED("deleted"),
    FINISHED ("finished");

    private final String value;

    FlightStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
