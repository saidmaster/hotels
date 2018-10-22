package org.hotel.res.Service.interfaces;

import java.util.List;

import org.hotel.res.Model.Hotel;
import org.springframework.web.multipart.MultipartFile;

public interface IHotelService {

	// get Hotel s list
	List<Hotel> getListHotels();
	
	//Add hotel
	void addHotel(Hotel hotel , MultipartFile file);
	
	// get single hotel
	Hotel getHotel(Long idHotel);
	
	//Delete hotel
	void deleteHotel(Long idHotel);
	
	// update hotel
	void updateHotel(Hotel hotel , MultipartFile file);
	
	// get single Hotel
	Hotel getHotelById(Long idHotel);
}
