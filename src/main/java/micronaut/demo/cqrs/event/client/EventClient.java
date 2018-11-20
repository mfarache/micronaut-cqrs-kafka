package micronaut.demo.cqrs.event.client;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.Body;
import micronaut.demo.cqrs.event.AbstractEvent;

@KafkaClient
public interface EventClient<T> {

    @Topic("movies") 
    void sendEvent(@KafkaKey String movieId, @Body AbstractEvent<T> movieEvent); 
}
