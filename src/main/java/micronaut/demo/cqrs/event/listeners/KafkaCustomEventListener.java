package micronaut.demo.cqrs.event.listeners;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Primary;
import io.micronaut.messaging.annotation.Body;
import micronaut.demo.cqrs.event.MovieCreatedEvent;
import micronaut.demo.movie.services.read.QueryMovieViewDao;

@KafkaListener
@Primary
public class KafkaCustomEventListener {
	
	protected static final Logger LOG = LoggerFactory.getLogger(KafkaCustomEventListener.class);
	
	@Inject
	private QueryMovieViewDao dao;
	
	@Topic("movies")
	public void consume( @KafkaKey String movieId, @Body MovieCreatedEvent movieEvent) {
		LOG.debug("KAKFA EVENT RECEIVED AT CUSTOM APPLICATION LISTENER");
		dao.save(movieEvent.getDtoFromEvent());
	}
}
