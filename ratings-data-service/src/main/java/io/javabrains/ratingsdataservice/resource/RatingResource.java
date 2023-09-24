package io.javabrains.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRatings;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 9);
	}

	@RequestMapping("user/{userId}")
	public UserRatings getRatings(@PathVariable("userId") String userIdId) {
		List<Rating> ratingList = Arrays.asList(new Rating("MovieId_1", 4), new Rating("MovieId_2", 5),
				new Rating("MovieId_3", 6), new Rating("MovieId_4", 7), new Rating("MovieId_5", 7));

		UserRatings userRatings = new UserRatings();
		userRatings.setUserRatings(ratingList);
		return userRatings;

	}
}
