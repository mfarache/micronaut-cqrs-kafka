package micronaut.demo.cqrs.event.listeners;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Primary;
import io.micronaut.context.event.ApplicationEventListener;
import micronaut.demo.cqrs.event.AbstractEvent;
import micronaut.demo.cqrs.event.MovieCreatedEvent;
import micronaut.demo.movie.model.Movie;
import micronaut.demo.movie.services.read.QueryMovieViewDao;

@Singleton
public class MovieEventsListener implements ApplicationEventListener<AbstractEvent<Movie>> {

	protected static final Logger LOG = LoggerFactory.getLogger(MovieEventsListener.class);
	
	@Inject
	private QueryMovieViewDao dao;

	@Override
	public void onApplicationEvent(AbstractEvent<Movie> event) {
		LOG.debug("EVENT RECEIVED:" +  event);
		if (event instanceof MovieCreatedEvent) {
			LOG.debug("EVENT RECEIVED AT APPLICATION LISTENER");
			dao.save(((MovieCreatedEvent) event).getDtoFromEvent());
		}
	}
}
