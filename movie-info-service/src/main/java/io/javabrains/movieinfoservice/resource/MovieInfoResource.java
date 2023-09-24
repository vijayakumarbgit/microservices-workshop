package io.javabrains.movieinfoservice.resource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	List<Movie> mList = Arrays.asList(new Movie("MovieId_1", "KGF", "A kannada mass movie with rich execution"),
			new Movie("MovieId_2", "Kanthara", "Story oriented movie and must watch movie "),
			new Movie("MovieId_3", "BahuBali", "One of the best the telugu movie"),
			new Movie("MovieId_4", "Jailer", "Nice movie and treat for Rajini kanth fans"),
			new Movie("MovieId_5", "DHOOM", "Best bollywood movie"));

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

		Movie movie = null;
		Iterator<Movie> itr = mList.iterator();
		while (itr.hasNext()) {
			movie = itr.next();
			if (movie.getMovieId().equals(movieId)) {
				return movie;
			}
		}
		return null;
	}
}
