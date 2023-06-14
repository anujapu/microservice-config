package com.user.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.entity.Rating;

@Service
@FeignClient("RATING-SERVICE")
public interface RatingService {

	@GetMapping("ratings/users/{userId}")
	Rating getRating(String userId);
	
	@PostMapping("/ratings")
	public Rating createRating(Rating values);
	
	@PutMapping("/ratings/{ratingsId}")
	public Rating updateRating(@PathVariable String ratingId,Rating values);
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
}
