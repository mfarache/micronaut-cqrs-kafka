package micronaut.demo.cqrs.event.client;

import javax.inject.Inject;

import io.micronaut.context.event.ApplicationEventPublisher;
import micronaut.demo.cqrs.event.AbstractEvent;
import micronaut.demo.movie.model.Movie;

public class AppContextPublisher implements EventPublisher<Movie> {
	
	@Inject
	ApplicationEventPublisher publisher;

	@Override
	public void publish(AbstractEvent<Movie> event) {
		publisher.publishEvent(event);
	}
}
