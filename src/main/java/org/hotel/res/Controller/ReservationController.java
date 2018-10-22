package org.hotel.res.Controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.http.HttpStatus;
import org.apache.log4j.spi.LoggerFactory;
import org.hotel.res.Model.Reservation;
import org.hotel.res.Service.Impl.ReservationServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ReservationController {

	private static final Logger logger =  org.slf4j.LoggerFactory.getLogger(ReservationController.class);
	 	@Autowired
	    private JavaMailSender sender;
	 	
	 	@Autowired
	 	private ReservationServiceImpl reservationService;

	    @PostMapping("/reservation")
	    public ResponseEntity<Boolean> addReservation(@RequestBody Reservation reservation) {
	        try {
	            sendEmail(reservation);
	            reservationService.addReservation(reservation);
	            return new ResponseEntity<Boolean>(true , org.springframework.http.HttpStatus.OK);
	        }catch(Exception ex) {
	           logger.info("Error from addReservation : " , ex.getMessage());
	           return new ResponseEntity<Boolean>(false , org.springframework.http.HttpStatus.NO_CONTENT);
	        }
	    }

	    private void sendEmail(Reservation res) throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        
	        helper.setTo("said.bahaouary@gmail.com");
	        
	        helper.setSubject("Reservation from " + res.getUser_reservation().getEmail());
	        
	        message.setContent(""
	        		+ "<!DOCTYPE html>\n" + 
	        		"<html>\n" + 
	        		"<head>\n" + 
	        		"<style>\n" + 
	        		"table {\n" + 
	        		"    border-collapse: collapse;\n" + 
	        		"    width: 100%;\n" + 
	        		"}\n" + 
	        		"\n" + 
	        		"th, td {\n" + 
	        		"    text-align: left;\n" + 
	        		"    padding: 8px;\n" + 
	        		"}\n" + 
	        		"\n" + 
	        		"tr:nth-child(even){background-color: #f2f2f2}\n" + 
	        		"\n" + 
	        		"th {\n" + 
	        		"    background-color: #4CAF50;\n" + 
	        		"    color: white;\n" + 
	        		"}\n" + 
	        		"</style>\n" + 
	        		"</head>\n" + 
	        		"<body>\n" + 
	        		"\n" + 
	        		"<h2>Reservation Hotel " + res.getHotel().getName() + " </h2>\n" + 
	        		"\n" + 
	        		"<table>\n" + 
	        		"  <tr>\n" + 
	        		"    <th>Nom et Prenom</th>\n" + 
	        		"    <th>Email</th>\n" + 
	        		"    <th>Numero Telephone</th>\n" + 
	        		"  </tr>\n" + 
	        		"  <tr>\n" + 
	        		"    <td>"+ res.getUser_reservation().getFirstName()+"</td>\n" + 
	        		"    <td>"+ res.getUser_reservation().getEmail()+"</td>\n" + 
	        		"    <td>"+ res.getUser_reservation().getTelephone()+"</td>\n" + 
	        		"  </tr>\n" 
	        		+  
	        		"</table>\n" + 
	        		"\n" + 
	        		"</body>\n" + 
	        		"</html>","text/html" );  

	        
	        
	        sender.send(message);
	    }
	    
	    @GetMapping("/getListReservations")
	    public ResponseEntity< List<Reservation> > getListReservation (){
	    	return new ResponseEntity<List<Reservation>>(reservationService.getListReservation(), org.springframework.http.HttpStatus.OK);
	    }
	    
	    @GetMapping("/reservation")
		public ResponseEntity<Reservation> getReservationFromController(@RequestParam("id") String id){
			return  new ResponseEntity<Reservation>(reservationService.getReservationById(Long.parseUnsignedLong(id)), org.springframework.http.HttpStatus.OK);
		}
}
