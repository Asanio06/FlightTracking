package fr.flight_tracking.live_map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class LiveMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveMapApplication.class, args);
	}

}
