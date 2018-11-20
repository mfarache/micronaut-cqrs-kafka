package micronaut.demo.movie.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import micronaut.demo.movie.model.Movie;
import micronaut.demo.movie.services.write.MovieService;


@Controller("/movies-write")
public class MovieWriteEndpoint {

	private MovieService writeService;
	
	public MovieWriteEndpoint(MovieService writeService) {
		super();
		this.writeService = writeService;
	}


    @Post()
    public HttpResponse<Movie> save(@Body Movie movie) {
    		writeService.addMovie(movie);
    	    return HttpResponse.ok(movie);
    }
}
