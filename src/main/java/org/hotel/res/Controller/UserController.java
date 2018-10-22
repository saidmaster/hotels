package org.hotel.res.Controller;

import java.security.Principal;
import java.util.List;

import org.hotel.res.Model.User;
import org.hotel.res.Service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/*")
public class UserController {

	// logger 
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> getUsers() {
		logger.info("user mail : " + userService.getListOfUsers().get(0).getEmail().toString() );
		
		return new ResponseEntity<List<User>>(userService.getListOfUsers() , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody User user) {
	

		if(userService.findUserByName(user.getEmail()) != null) {
			return new ResponseEntity("User : " + user.getEmail() + " already existed" , HttpStatus.CONFLICT);
			
		}else {
			User usr = userService.saveOrUpdate(user);
			return new ResponseEntity<User>(usr, HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/login")
	public Principal login(Principal user) {
		logger.info("principal " + user);
		return user;
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user){
		User usr = userService.saveOrUpdate(user);
		return new ResponseEntity<User>(usr, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam Long id) {	
		userService.delete(id);
	}
	
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public User getUser(@RequestParam("id") String id){
		return  userService.findUserById(Long.parseUnsignedLong(id));
	}
	
	@RequestMapping(value = "/userEmail" , method = RequestMethod.GET)
	public User getUserByEmail(@RequestParam("email") String email){
		return  userService.findUserByName(email);
	}
}
