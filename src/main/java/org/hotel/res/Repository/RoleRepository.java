package org.hotel.res.Repository;

import java.util.stream.Stream;

import org.hotel.res.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role , Long>{

	@Query("select role from Role role where role.role_name = :rolename")
	public Role findByRoleName(@Param("rolename") String rolename);
	
	@Query("select role from Role role")
	Stream<Role> getListRoleStream();
}
