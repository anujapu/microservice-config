package com.user.controller;

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

import com.user.entity.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User u)
	{
		User user=this.userService.saveUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	int retryCount=1;
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	//@Retry(name="ratingHotelService", fallbackMethod ="ratingHotelFallback")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUserById(@PathVariable String userId)
	{
		System.out.println("RetryCOunt"+retryCount);
		retryCount++;
		User user = this.userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//creating fallback method for circuitBreaker
	
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception e)
	{
		System.out.println("Fallback Method exececuted as service is down"+e.getMessage());
		User u=new User("dummy", "dummy", "dummy@gmail.com", "Dummy user as service is down");
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<User>>getAllUsers()
	{
		List<User> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
}
