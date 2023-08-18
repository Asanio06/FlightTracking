package fr.flight_tracking.aircraft_data_receiver.dto;

public record SurfaceControl(
        Boolean isNoSmokingAlertActive,
        Boolean isSeatbeltsSignActive,
        Boolean isFlapsAvailable,
        Boolean isFlapsOn,
        Boolean isSpoilerAvailable,
        Boolean isSpoilerArm,
        Boolean isSpoilerOn
) {
}