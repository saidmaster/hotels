package org.hotel.res.Service.Impl;

import java.util.List;

import org.hotel.res.Controller.UploadFile;
import org.hotel.res.Model.Hotel;
import org.hotel.res.Model.Reservation;
import org.hotel.res.Repository.HotelRepository;
import org.hotel.res.Service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	
	// get Hotel s list
	
	@Override
	public List<Hotel> getListHotels(){
	
		return (List<Hotel>) hotelRepository.findAll();
	}
	
	// add Hotel
	@Override
	public void addHotel(Hotel hotel , MultipartFile file) {
		
		hotelRepository.save(hotel);
		UploadFile.singleFileUpload(file);
	}
	
	// get single hotel
	@Override
	public Hotel getHotel(Long idHotel) {
		
		return hotelRepository.findOne(idHotel);
	}
	// delete hotel
	@Override
	public void deleteHotel(Long idHotel) {
		
		hotelRepository.delete(getHotel(idHotel));
	}
	// update hotel
	@Override
	public void updateHotel(Hotel hotel , MultipartFile file) {
		UploadFile.singleFileUpload(file);
		hotelRepository.save(hotel);
	}
	
	// get single Hotel
	@Override
	public Hotel getHotelById(Long idHotel) {
		
		return hotelRepository.findOne(idHotel);
	}

}
