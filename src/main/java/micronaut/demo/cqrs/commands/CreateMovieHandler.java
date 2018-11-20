package micronaut.demo.cqrs.commands;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import micronaut.demo.cqrs.event.AbstractEvent;
import micronaut.demo.cqrs.event.MovieCreatedEvent;
import micronaut.demo.cqrs.event.client.EventPublisher;
import micronaut.demo.cqrs.model.Command;
import micronaut.demo.cqrs.model.Result;
import micronaut.demo.movie.model.Movie;
import micronaut.demo.movie.model.MovieResult;
import micronaut.demo.movie.services.write.Dao;

@Singleton
public class CreateMovieHandler extends AbstractCommandHandler<Movie>{
	
	protected static final Logger LOG = LoggerFactory.getLogger(CreateMovieHandler.class);
	
	@Inject
	public CreateMovieHandler(Dao<Movie> dao, EventPublisher<Movie> publisher) {
		super(dao, publisher);

	}

	@Override
	Movie getDto(Command<Movie> command) {
		Movie movie = ((CreateMovieCommand) command).getMovie();
		LOG.debug("movie:" + movie.getId() + "," + movie.getDescription());
		return movie;
	}

	@Override
	AbstractEvent<Movie> buildEvent(Movie movie) {
		return new MovieCreatedEvent(movie);
	}

	@Override
	void save(Movie dto) {
		dao.save( dto);
	}

	@Override
	Result<Movie> buildResult(Movie dto) {
		return new MovieResult();
	}
}
