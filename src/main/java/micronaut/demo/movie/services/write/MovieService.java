package micronaut.demo.movie.services.write;

import javax.inject.Inject;

import micronaut.demo.cqrs.bus.Bus;
import micronaut.demo.cqrs.commands.CreateMovieCommand;
import micronaut.demo.movie.model.Movie;

public class MovieService {
	
	@Inject
	private Bus bus;
	
	public void addMovie(Movie m) {
		bus.handleCommand(new CreateMovieCommand(m));
	}
}
