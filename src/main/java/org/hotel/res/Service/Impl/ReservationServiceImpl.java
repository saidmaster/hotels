package org.hotel.res.Service.Impl;

import java.util.List;

import org.hotel.res.Model.Reservation;
import org.hotel.res.Repository.ReservationRepository;
import org.hotel.res.Service.interfaces.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	
	// get Reservations list
	@Override
	public List<Reservation> getListReservation(){
	
		return (List<Reservation>) reservationRepository.findAll();
	}
	
	// add Reservation
	@Override
	public void addReservation(Reservation reservation) {
		
		reservationRepository.save(reservation);
	}
	
	// get single Repository
	@Override
	public Reservation getReservationById(Long idReservation) {
		
		return reservationRepository.findOne(idReservation);
	}
	// delete reservation
	@Override
	public void deteleReservation(Long idReservation) {
		
		reservationRepository.delete(getReservationById(idReservation));
	}
	
	//update reservation
	@Override
	public void updateReservation(Reservation reservation) {		
		reservationRepository.save(reservation);
	}
}
