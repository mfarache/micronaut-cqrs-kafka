package micronaut.demo.movie.services.read;

import java.util.List;

import javax.inject.Inject;

import micronaut.demo.movie.model.Movie;


public class QueryMovieService {
	
	@Inject
	QueryMovieViewDao dao;
	
	public List<Movie> getMovies() {
		return dao.getMovies();
	}
}
