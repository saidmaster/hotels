package org.hotel.res.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ville")
public class Ville implements Serializable{

	@Id @GeneratedValue
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ville(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Ville() {
		super();
	}
	
	
	
}
