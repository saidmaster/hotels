package org.hotel.res.Service.interfaces;

import java.security.Principal;

import org.hotel.res.Model.User;

public interface IAuth {

	Principal login(Principal user);
	void logout ();
	
	Principal getPrincipalUser() ;
}
