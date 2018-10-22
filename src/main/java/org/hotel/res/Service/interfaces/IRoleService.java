
package org.hotel.res.Service.interfaces;

import java.util.List;


import org.hotel.res.Model.Role;

public interface IRoleService {

	
	List< Role > getListOfRoles();
	
	Role saveOrUpdate(Role role);
	
	void delete(Long idRole);
	
	Role findRoleById(Long idRole);
	
	Role findRoleByName(String name);
}
