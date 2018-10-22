package org.hotel.res.Controller;

import java.util.List;

import org.hotel.res.Model.Chambre;
import org.hotel.res.Service.Impl.ChambreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChambreController {

	
	@Autowired
	private ChambreServiceImpl chambreService;
	
	@GetMapping("chambre")
	public ResponseEntity<List<Chambre>> getChambreController(@RequestParam("code_chambre") String code_chambre){
		
		List<Chambre> listChambre = chambreService.getChambres(code_chambre);
		
		return new ResponseEntity<List<Chambre>>( listChambre, HttpStatus.OK);
	}
	
}
