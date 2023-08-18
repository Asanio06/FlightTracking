package fr.flight_tracking.aircraft_data_receiver.dto;








public record AircraftStateInput(Position position,
                                 Fuel fuel,
                                 Autopilot autopilot,
                                 Panel panel,
                                 Light light,
                                 SurfaceControl surfaceControl,
                                 Integer groundSpeed,
                                 Integer indicatedSpeed,
                                 Integer trueAirSpeed,
                                 Integer heading,
                                 Integer magneticTrack,
                                 Float altimeterQnhParameter,
                                 Float outsidePressure,
                                 Boolean isAutobrakeOn,
                                 Boolean isDoorOpen,
                                 Integer verticalSpeed,
                                 Boolean isParkingBrakeSet,
                                 Boolean isGearPositionIsUp,
                                 Boolean isEnginesStart,
                                 String engineType
) {
}
