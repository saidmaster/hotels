package org.hotel.res.Service.Impl;

import java.security.Principal;

import org.hotel.res.Model.User;
import org.hotel.res.Service.interfaces.IAuth;
import org.springframework.stereotype.Service;

@Service
public class AuthImpl implements IAuth{

	private Principal principal;
	
	@Override
	public Principal login(Principal princial) {
		this.principal = princial;
		return princial;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Principal getPrincipalUser() {
		// TODO Auto-generated method stub
		return this.principal;
	}	
}
