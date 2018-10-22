package org.hotel.res.Service.Impl;

import java.util.List;

import org.hotel.res.Model.Role;
import org.hotel.res.Repository.RoleRepository;
import org.hotel.res.Service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getListOfRoles() {
		// TODO Auto-generated method stub
		return (List<Role>)roleRepository.findAll();
	}

	@Override
	public Role saveOrUpdate(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void delete(Long idRole) {
		
		roleRepository.delete(findRoleById(idRole));

	}

	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRoleById(Long idRole) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(idRole);
	}

}
