package fr.flight_tracking.live_map.model;

import fr.flight_tracking.kafka.model.AircraftState;

import java.util.ArrayList;
import java.util.List;

public class FlightAircraftStateHistoryImpl {

    private List<AircraftState> aircraftStates = new ArrayList();


    public FlightAircraftStateHistoryImpl(){

    }

    public FlightAircraftStateHistoryImpl addAircraftState(AircraftState aircraftState){
        aircraftStates.add(aircraftState);
        return this;
    }


}
