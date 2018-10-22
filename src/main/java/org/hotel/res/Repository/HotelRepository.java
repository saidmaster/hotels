package org.hotel.res.Repository;

import java.util.stream.Stream;

import org.hotel.res.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

	@Query("select hotel from Hotel hotel where hotel.name like %:hotelname%")
	
	Stream<Hotel> getListHotelLike(@Param("hotelname") String hotelname);
	
}
