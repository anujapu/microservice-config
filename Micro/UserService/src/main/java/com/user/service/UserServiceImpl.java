package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.external.services.HotelService;
import com.user.repository.UserRepository;
import java.util.stream.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User u) {
		
		String randomUUID = UUID.randomUUID().toString();
		u.setUserId(randomUUID);
		return this.userRepo.save(u);
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = this.userRepo.findAll();
		return allUsers;
	}

	@Override
	public User getUser(String userId) {
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not present"+userId));
		System.out.println(user.getUserId());
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
		System.out.println(ratingsOfUser);
		List<Rating> list = Arrays.stream(ratingsOfUser).toList();
		
		List<Rating> ratingList=list.stream().map(rating -> {
		Hotel hotel=hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}


}
