package micronaut.demo.movie.api;

import java.util.List;

import javax.inject.Inject;

import org.h2.tools.Server;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import micronaut.demo.movie.model.Movie;
import micronaut.demo.movie.services.read.QueryMovieService;


@Controller("/movies-read")
public class MovieReadEndpoint {

	private QueryMovieService queryService;

	public MovieReadEndpoint(QueryMovieService queryService) {
		super();
		this.queryService = queryService;
	}
    
    @Get("/all")
    public HttpResponse<List<Movie>> get() {
    	    return HttpResponse.ok(queryService.getMovies());
    }
}
