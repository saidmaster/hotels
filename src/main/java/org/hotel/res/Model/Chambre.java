package org.hotel.res.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chambre")
public class Chambre implements Serializable{

	@Id @GeneratedValue
	private Long id;
	
	private String typec;
	
	private String typel;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypec() {
		return typec;
	}

	public void setTypec(String typec) {
		this.typec = typec;
	}

	public String getTypel() {
		return typel;
	}

	public void setTypel(String typel) {
		this.typel = typel;
	}

	public Chambre(Long id, String typec, String typel) {
		super();
		this.id = id;
		this.typec = typec;
		this.typel = typel;
	}

	public Chambre() {
		super();
	}	
	
}
