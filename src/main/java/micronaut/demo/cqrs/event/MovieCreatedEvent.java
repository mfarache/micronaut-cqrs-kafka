package micronaut.demo.cqrs.event;

import java.io.Serializable;

import micronaut.demo.movie.model.Movie;

public class MovieCreatedEvent extends AbstractEvent<Movie> implements  Serializable{

	private static final long serialVersionUID = -7452000227812130114L;
	
	private Movie movie;
	
	public MovieCreatedEvent() {

	}

	public MovieCreatedEvent( Movie movie) {
		this.movie = movie;
	}

	@Override
	public String getEventId() {
		return getDtoFromEvent().getId();
	}

	@Override
	public Movie getDtoFromEvent() {
		return this.movie;
	}

}
