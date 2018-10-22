package org.hotel.res.Repository;

import java.util.List;

import org.hotel.res.Model.Chambre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChambreRepository extends JpaRepository<Chambre, Long>{

	@Query("select c from Chambre c where code_chambre = :code_chambre")
	List<Chambre> listChambre(@Param("code_chambre") String code_chambre);
	
}
