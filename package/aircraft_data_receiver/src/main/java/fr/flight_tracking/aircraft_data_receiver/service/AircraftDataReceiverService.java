package fr.flight_tracking.aircraft_data_receiver.service;

import fr.flight_tracking.kafka.model.AircraftState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AircraftDataReceiverService {
    @Value("${config.kafka.aircraft-state-topic.name}")
    private String aircraftStateTopicName;

    private final KafkaTemplate<String, AircraftState> kafkaTemplate;


    @Autowired
    public AircraftDataReceiverService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAircraftData(UUID flightId, AircraftState aircraftState) {

        CompletableFuture<SendResult<String, AircraftState>> future = kafkaTemplate.send(aircraftStateTopicName, String.valueOf(flightId), aircraftState);
        future.whenComplete((result, ex) -> {
            if (result == null) {
                System.out.println("Problem");
                return;
            }
            
            System.out.println("All is ok");

        });


    }
}
