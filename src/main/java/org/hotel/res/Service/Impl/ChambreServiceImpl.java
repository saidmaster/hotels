package org.hotel.res.Service.Impl;

import java.util.List;

import org.hotel.res.Model.Chambre;
import org.hotel.res.Repository.ChambreRepository;
import org.hotel.res.Service.interfaces.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChambreServiceImpl implements IChambreService {

	@Autowired
	private ChambreRepository chambreRepository;
	
	@Override
	public List<Chambre> getChambres(String code_chambre) {
		return (List<Chambre>)chambreRepository.listChambre(code_chambre);
	}

}
