package micronaut.demo.cqrs.event.client;

import javax.inject.Inject;

import io.micronaut.context.annotation.Primary;
import micronaut.demo.cqrs.event.AbstractEvent;
import micronaut.demo.movie.model.Movie;

@Primary
public class KafkaPublisher implements EventPublisher<Movie> {
	
	@Inject
	EventClient<Movie> eventClient; 

	@Override
	public void publish(AbstractEvent<Movie> event) {
		eventClient.sendEvent(event.getEventId(), event);
	}
}
