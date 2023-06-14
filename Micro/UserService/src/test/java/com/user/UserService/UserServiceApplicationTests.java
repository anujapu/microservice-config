package com.user.UserService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.entity.Rating;
import com.user.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;
	
	@Test
	void contextLoads() {
	}

	/*@Test
	void createRating(Rating values)
	{
		Rating rating=new Rating("25", "266", "122", 10, "ssdsdsdsd");
		Rating createRating = ratingService.createRating(rating);
		System.out.println("rating created"+createRating);
		
	}*/
}


