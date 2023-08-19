package fr.flight_tracking.live_map.topology;


import fr.flight_tracking.kafka.model.AircraftState;
import fr.flight_tracking.kafka.model.Position;
import io.confluent.kafka.streams.serdes.protobuf.KafkaProtobufSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig.SPECIFIC_PROTOBUF_VALUE_TYPE;

@Component
public class FlightHistoryTopology {
    @Value("${config.kafka.aircraft-state-topic.name}")
    private String aircraftStateTopicName;

    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaUrl;


    private KafkaProtobufSerde<AircraftState> getAircraftProtobufSerdes() {
        var kafkaProtobufSerde = new KafkaProtobufSerde<AircraftState>();
        Map<String, String> serdeConfig = new HashMap<>();
        serdeConfig.put(SCHEMA_REGISTRY_URL_CONFIG, schemaUrl);
        serdeConfig.put(SPECIFIC_PROTOBUF_VALUE_TYPE, AircraftState.class.getName());

        kafkaProtobufSerde.configure(serdeConfig, false);
        return kafkaProtobufSerde;
    }


    private KafkaProtobufSerde<Position> getPositionProtobufSerde() {
        var kafkaProtobufSerde = new KafkaProtobufSerde<Position>();
        Map<String, String> serdeConfig = new HashMap<>();
        serdeConfig.put(SCHEMA_REGISTRY_URL_CONFIG, schemaUrl);
        serdeConfig.put(SPECIFIC_PROTOBUF_VALUE_TYPE, Position.class.getName());

        kafkaProtobufSerde.configure(serdeConfig, false);
        return kafkaProtobufSerde;
    }

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {


        var aircraftProtobufSerdes = getAircraftProtobufSerdes();
        var positionProtobufSerde = getPositionProtobufSerde();

        streamsBuilder
                .stream(aircraftStateTopicName, Consumed.with(Serdes.String(), aircraftProtobufSerdes))
                .mapValues((aircraftState -> aircraftState.getPosition()))
                .to("aircraft-position-topic-2", Produced.with(Serdes.String(), positionProtobufSerde));
    }
}
