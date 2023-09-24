package io.javabrains.moviecatalogservice.models;

public class Movie {

	public Movie() {
	}

	public Movie(String movieId, String name, String desc) {
		this.movieId = movieId;
		this.name = name;
		this.desc = desc;
	}

	private String movieId;
	private String name;
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
