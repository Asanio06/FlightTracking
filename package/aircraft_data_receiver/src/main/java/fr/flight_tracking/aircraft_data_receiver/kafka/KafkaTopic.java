package fr.flight_tracking.aircraft_data_receiver.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Value("${config.kafka.aircraft-state-topic.name}")
    private String aircraftStateTopicName;

    @Value("${config.kafka.aircraft-state-topic.partitions}")
    private int aircraftStateTopicPartitions;

    @Value("${config.kafka.aircraft-state-topic.replicas}")
    private int aircraftStateTopicReplicas;

    @Bean
    public NewTopic aircraftStateTopic() {
        return TopicBuilder.name(aircraftStateTopicName)
                .partitions(aircraftStateTopicPartitions)
                .replicas(aircraftStateTopicReplicas)
                .build();
    }
}
