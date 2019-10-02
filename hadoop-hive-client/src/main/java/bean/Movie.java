package bean;

public class Movie {

	private Long movieId;
	private String movieName;
	private String imdbLink;
	private String release;
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getImdbLink() {
		return imdbLink;
	}
	public void setImdbLink(String imdbLink) {
		this.imdbLink = imdbLink;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", imdbLink=" + imdbLink + ", release="
				+ release + "]";
	}
	
}
