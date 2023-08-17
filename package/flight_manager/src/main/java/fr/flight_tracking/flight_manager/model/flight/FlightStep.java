package fr.flight_tracking.flight_manager.model.flight;

public enum FlightStep {

    NONE ("none"),
    GROUNG ("ground"),
    BOARDING ("boarding"),
    PUSHBACK ("pushback"),
    BLOCK_ON ("block_on"),
    TAXI_OUT ("taxi_out"),
    TAKEOFF ("takeoff"),
    INITIAL_CLIMB ("initial_climb"),
    CLIMB ("climb"),
    CRUISE ("cruise"),
    DESCENT ("descent"),
    APPROACH ("approach"),
    LANDING ("landing"),
    TAXI_IN ("taxi_in"),
    BLOCK_OFF ("block_off"),
    DEBOARDING ("deboarding"),
    PARKED ("parked"),
    EMERGENCY ("emergency"),
    CRASHED ("crashed"),
    DIVERSION ("diversion");

    private final String value;

    FlightStep(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
