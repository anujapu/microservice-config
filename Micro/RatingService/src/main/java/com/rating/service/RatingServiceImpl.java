package com.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.repository.RatingRepository;

@Service

public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository ratingRepo;
	
	@Override
	public Rating createRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		Rating savedRating = this.ratingRepo.save(rating);
		return savedRating;
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		List<Rating> rating=this.ratingRepo.findByUserId(userId);
		return rating;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> ratings=this.ratingRepo.findAll();
		return ratings;
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		List<Rating> ratings=this.ratingRepo.findByHotelId(hotelId);
		return ratings;
	}

}
