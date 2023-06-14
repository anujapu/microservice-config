package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		Rating createdRating=this.ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
	{
		List<Rating> createdRating=this.ratingService.getRatingsByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(createdRating);
	}
	
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		List<Rating> createdRating=this.ratingService.getRatingsByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(createdRating);
	}

	
}


