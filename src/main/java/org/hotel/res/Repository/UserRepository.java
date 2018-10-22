package org.hotel.res.Repository;

import org.hotel.res.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.email = :email")
	User findByUserName(@Param("email") String email);
	
}
