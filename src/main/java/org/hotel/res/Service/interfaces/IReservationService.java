package org.hotel.res.Service.interfaces;

import java.util.List;

import org.hotel.res.Model.Reservation;

public interface IReservationService {

		// get Reservations list
		List<Reservation> getListReservation();
		
		// add Reservation
		void addReservation(Reservation reservation) ;
		
		// get single Repository
		Reservation getReservationById(Long idReservation);
		
		
		// delete reservation
		void deteleReservation(Long idReservation) ;
		
		// update reservation
		void updateReservation(Reservation reservation) ;
}
