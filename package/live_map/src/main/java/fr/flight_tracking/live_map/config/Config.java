package fr.flight_tracking.live_map.config;

import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${config.ksqldb.host}")
    private String ksqlDbServerHost;


    @Value("${config.ksqldb.port}")
    private Integer ksqlDbServerHostPort;


    @Bean
    public Client createKsqlClient() {
        ClientOptions options = ClientOptions.create()
                .setHost(ksqlDbServerHost)
                .setPort(ksqlDbServerHostPort);
        Client client = Client.create(options);

        return client;
    }
}
