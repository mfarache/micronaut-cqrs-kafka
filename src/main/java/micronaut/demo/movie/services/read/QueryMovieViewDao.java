package micronaut.demo.movie.services.read;

import java.util.List;

import micronaut.demo.movie.model.Movie;

public interface QueryMovieViewDao {

	List<Movie> getMovies();
	
	void save(Movie movie);

}
