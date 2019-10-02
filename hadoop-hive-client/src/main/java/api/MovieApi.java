package api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.Movie;
import bean.SearchBean;
import service.MovieService;

@Path("movies")
public class MovieApi {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> searchMovie(SearchBean search) {
		return MovieService.getMovies(search.getSearch());
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies() {

		return MovieService.getMovies();
	}

}
