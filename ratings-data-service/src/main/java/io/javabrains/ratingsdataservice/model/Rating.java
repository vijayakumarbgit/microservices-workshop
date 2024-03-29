package io.javabrains.ratingsdataservice.model;

public class Rating {

	private String movieId;
	private int ratings;

	public Rating() {}
	public Rating(String movieId, int ratings) {

		this.movieId = movieId;
		this.ratings = ratings;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

}
