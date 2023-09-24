package io.javabrains.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate resTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	// get all rated movie id's
	// for each movie id get movie info
	// put them all togther and send the response

	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String uid) {

		// RestTemplate restemplate = new RestTemplate();

		UserRatings userRatings = resTemplate.getForObject("http://MOVIE-RATING-SERVICE/ratings/user/" + uid,
				UserRatings.class);

		List<Rating> ratings = userRatings.getUserRatings();

		return ratings.stream().map(rating -> {

			// calling using restTemplate
			Movie movie = resTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(),
					Movie.class);

			// calling usinng webclinet
			/*
			 * Movie movie=webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movies/" + rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */

			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRatings());
		}).collect(Collectors.toList());

		// return Collections.singletonList(new CatalogItem("movie1", "Movie1 desc",
		// 5));
	}

}
