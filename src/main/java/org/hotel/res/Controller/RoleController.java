package org.hotel.res.Controller;

import java.util.List;

import org.hotel.res.Model.Role;
import org.hotel.res.Service.Impl.RoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles/*")
public class RoleController {

	// logger 
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleServiceImpl roleSevice;
	

	@GetMapping("list")
	
	public ResponseEntity<List<Role>> getRoles(){
		
		return new ResponseEntity<List<Role>> ( roleSevice.getListOfRoles(), HttpStatus.OK);
	}
}
