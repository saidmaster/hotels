package org.hotel.res.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hotel.res.Model.Ville;
@Entity
public class Hotel implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;
	private double price;

	@OneToMany
	@JoinColumn(name = "code_image")
	private Set<Image> linkImage;
	
	
	@OneToMany
	@JoinColumn(name = "code_chambre")
	private Set<Chambre> chambre;

	@ManyToOne
	@JoinColumn(name = "code_ville", nullable = false)
	private Ville ville;

	

	public Hotel() {
	}

	public Hotel(Long id, String name, String description, double price, Set<Image> linkImage, Set<Chambre> chambre,
			Ville ville) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.linkImage = linkImage;
		this.chambre = chambre;
		this.ville = ville;
	}

	public Hotel(String name, String description, double price, Set<Image> linkImage, Set<Chambre> chambre,
			Ville ville) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.linkImage = linkImage;
		this.chambre = chambre;
		this.ville = ville;
	}

	public Hotel(Long id, String name, String description, double price, Set<Image> linkImage) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.linkImage = linkImage;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Image> getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(Set<Image> linkImage) {
		this.linkImage = linkImage;
	}
	
	

	public Set<Chambre> getChambre() {
		return chambre;
	}

	public void setChambre(Set<Chambre> chambre) {
		this.chambre = chambre;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkImage == null) ? 0 : linkImage.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Hotel other = (Hotel) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkImage == null) {
			if (other.linkImage != null)
				return false;
		} else if (!linkImage.equals(other.linkImage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
