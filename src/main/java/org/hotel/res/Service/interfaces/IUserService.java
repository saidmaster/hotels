package org.hotel.res.Service.interfaces;

import java.util.List;
import java.util.stream.Stream;

import org.hotel.res.Model.User;

public interface IUserService {

	List<User> getListOfUsers();
	
	User saveOrUpdate(User user);
	
	User findUserByName(String username);
	
	User findUserById(Long id);
	
	void delete(Long idUser);
}