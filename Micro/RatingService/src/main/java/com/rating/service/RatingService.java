package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingsByHotelId(String hotelId);
	
}
