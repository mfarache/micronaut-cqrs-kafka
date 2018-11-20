package micronaut.demo.movie.services.read;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import micronaut.demo.movie.model.Movie;

@Singleton
public class QueryMovieViewList implements QueryMovieViewDao {

	List<Movie> movies = new ArrayList<>();

	public List<Movie> getMovies() {
		return movies;
	}

	public void save(Movie m) {
		movies.add(m);
	}

}
