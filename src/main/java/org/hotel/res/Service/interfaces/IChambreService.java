package org.hotel.res.Service.interfaces;

import java.util.List;

import org.hotel.res.Model.Chambre;

public interface IChambreService {

	public List<Chambre> getChambres(String code_chambre);
}
