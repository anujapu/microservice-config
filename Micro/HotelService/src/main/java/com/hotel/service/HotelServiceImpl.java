package com.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepo;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String Id = UUID.randomUUID().toString();
		hotel.setId(Id);
		return this.hotelRepo.save(hotel);
		
	}

	@Override
	public Hotel getHotelById(String id) {
	Hotel hotel=this.hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not present"));
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return this.hotelRepo.findAll();
		
	}

}
