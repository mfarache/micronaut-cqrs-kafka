package micronaut.demo.movie.services.write;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import micronaut.demo.movie.model.Movie;

@Singleton
public class MovieDaoWriteList implements Dao<Movie> {

	private List<Movie> movies = new ArrayList<>();

	public void save(Movie movie) {
		movies.add(movie);
	}
}
