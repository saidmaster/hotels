package org.hotel.res.Controller;

import java.util.List;

import org.hotel.res.Model.Hotel;
import org.hotel.res.Model.Reservation;
import org.hotel.res.Service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HotelController {

	@Autowired
	private IHotelService hotelService;
	
	@RequestMapping(value = "/hotels" , method = RequestMethod.GET)
	public List<Hotel> getListHotel(){
		return hotelService.getListHotels();
	}
	
	
	@RequestMapping(value = "/hotel" , method = RequestMethod.GET)
	public Hotel getHotelFromController(@RequestParam("id") String id){
		return  hotelService.getHotelById(Long.parseUnsignedLong(id));
	}
	
	@PostMapping("hotel")
	
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel , @RequestParam MultipartFile file) {
		
		hotelService.addHotel(hotel , file );
		
		return new ResponseEntity<Hotel>(HttpStatus.OK);
		
	}
	
}
