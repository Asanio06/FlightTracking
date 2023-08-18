package fr.flight_tracking.aircraft_data_receiver.dto;

public record Light(
        Boolean isNavigationActive,
        Boolean isBeaconActive,
        Boolean isLandingActive,
        Boolean isTaxiActive,
        Boolean isStrobesActive,
        Boolean isInstrumentsActive,
        Boolean isRecognitionActive,
        Boolean isWingActive,
        Boolean isLogoLightActive,
        Boolean isCabinLightActive
) {
}