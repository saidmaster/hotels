package org.hotel.res.Service.Impl;

import java.util.List;
import java.util.stream.Stream;

import org.hotel.res.Model.User;
import org.hotel.res.Repository.UserRepository;
import org.hotel.res.Service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> getListOfUsers() {
		
		return (List<User>)userRepository.findAll();
	}

	@Transactional(readOnly=false)
	@Override
	public User saveOrUpdate(User user) {
	
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username);
	}

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long idUser) {
		
		userRepository.delete(findUserById(idUser));
		
	}

}
