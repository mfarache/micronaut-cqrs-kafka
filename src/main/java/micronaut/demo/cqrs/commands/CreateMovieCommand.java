package micronaut.demo.cqrs.commands;

import micronaut.demo.cqrs.model.Command;
import micronaut.demo.movie.model.Movie;

public class CreateMovieCommand implements Command<Movie> {
	
	private Movie movie;

	public CreateMovieCommand(Movie m) {
		this.movie = m;
	}

	public Movie getMovie() {
		return movie;
	}


}
