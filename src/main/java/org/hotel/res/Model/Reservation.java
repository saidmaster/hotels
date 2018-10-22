package org.hotel.res.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="reservation")
@Entity
public class Reservation implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	
	// hotel Info
	//@ManyToOne when user Exist 
	@ManyToOne
	@JoinColumn(name = "code_hotel")
	private Hotel hotel;
	
	
	@ManyToOne
	@JoinColumn(name = "code_chambre")
	private Chambre chambre;
	
	@OneToOne
	@JoinColumn(name = "user_reservation" , nullable = false)
	private User user_reservation;
	
	
	
	/*
	 * donnees d une reservation effectue par un client 
	 * 
	 * */
	// tempts reservation 
	private Date dateArrivee;
	
	private Date dateDepart;
	
	private Integer nombreAdult;
	
	private Integer nombreEnfant;
	
	private String message;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chambre == null) ? 0 : chambre.hashCode());
		result = prime * result + ((dateArrivee == null) ? 0 : dateArrivee.hashCode());
		result = prime * result + ((dateDepart == null) ? 0 : dateDepart.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((nombreAdult == null) ? 0 : nombreAdult.hashCode());
		result = prime * result + ((nombreEnfant == null) ? 0 : nombreEnfant.hashCode());
		result = prime * result + ((user_reservation == null) ? 0 : user_reservation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (chambre == null) {
			if (other.chambre != null)
				return false;
		} else if (!chambre.equals(other.chambre))
			return false;
		if (dateArrivee == null) {
			if (other.dateArrivee != null)
				return false;
		} else if (!dateArrivee.equals(other.dateArrivee))
			return false;
		if (dateDepart == null) {
			if (other.dateDepart != null)
				return false;
		} else if (!dateDepart.equals(other.dateDepart))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nombreAdult == null) {
			if (other.nombreAdult != null)
				return false;
		} else if (!nombreAdult.equals(other.nombreAdult))
			return false;
		if (nombreEnfant == null) {
			if (other.nombreEnfant != null)
				return false;
		} else if (!nombreEnfant.equals(other.nombreEnfant))
			return false;
		if (user_reservation == null) {
			if (other.user_reservation != null)
				return false;
		} else if (!user_reservation.equals(other.user_reservation))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public User getUser_reservation() {
		return user_reservation;
	}

	public void setUser_reservation(User user_reservation) {
		this.user_reservation = user_reservation;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Integer getNombreAdult() {
		return nombreAdult;
	}

	public void setNombreAdult(Integer nombreAdult) {
		this.nombreAdult = nombreAdult;
	}

	public Integer getNombreEnfant() {
		return nombreEnfant;
	}

	public void setNombreEnfant(Integer nombreEnfant) {
		this.nombreEnfant = nombreEnfant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Reservation(Long id, Hotel hotel, Chambre chambre, User user_reservation, Date dateArrivee, Date dateDepart,
			Integer nombreAdult, Integer nombreEnfant, String message) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.chambre = chambre;
		this.user_reservation = user_reservation;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.nombreAdult = nombreAdult;
		this.nombreEnfant = nombreEnfant;
		this.message = message;
	}

	public Reservation(Hotel hotel, Chambre chambre, User user_reservation, Date dateArrivee, Date dateDepart,
			Integer nombreAdult, Integer nombreEnfant, String message) {
		super();
		this.hotel = hotel;
		this.chambre = chambre;
		this.user_reservation = user_reservation;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.nombreAdult = nombreAdult;
		this.nombreEnfant = nombreEnfant;
		this.message = message;
	}

	public Reservation() {
		super();
	}
	
	
	
	
}
