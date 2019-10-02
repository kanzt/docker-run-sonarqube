package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bean.Movie;
import db.DatabaseCon;

public final class MovieService {

	private static Logger logger = Logger.getLogger(MovieService.class);
	
	private MovieService() {
		// Private constructor
	}
	
	public static List<Movie> getMovies() {
		try (Connection connect = DatabaseCon.connectDB();
				Statement state = connect.createStatement();
				ResultSet rows = state.executeQuery("select movie_id, movie_name, release, imdb_link from movies");) {
			return packMovie(rows);
		} catch (SQLException | ClassNotFoundException ex) {
			logger.error("Exception in MovieService::getMovies()",ex);
		}
		return new ArrayList<>();
	}

	public static List<Movie> getMovies(String search) {
		if (search != null && !search.equals("")) {
			try (Connection connect = DatabaseCon.connectDB();
					PreparedStatement state = connect.prepareStatement(
							"select movie_id, movie_name, release, imdb_link from movies where movie_name like ?");) {
				state.setString(1, "%" + search + "%");
				try (ResultSet rows = state.executeQuery();) {
					return packMovie(rows);
				}
			} catch (SQLException | ClassNotFoundException ex) {
				logger.error("Exception in MovieService::getMovies(String search)",ex);
			}
		} else {
			return MovieService.getMovies();
		}
		return new ArrayList<>();
	}
	
	private static List<Movie> packMovie(ResultSet rows) throws SQLException{
		List<Movie> movies = new ArrayList<>();
		logger.info("Running query...");
		while (rows.next()) {
			Movie movie = new Movie();
			movie.setMovieId(rows.getLong(1));
			movie.setMovieName(rows.getString(2));
			movie.setRelease(rows.getString(3));
			movie.setImdbLink(rows.getString(4));
			movies.add(movie);
		}
		return movies;
	}
}
