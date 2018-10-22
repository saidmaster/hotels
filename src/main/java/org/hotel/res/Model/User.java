package org.hotel.res.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.Columns;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="User")
@XmlRootElement(name="user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "USER_ID" , updatable = false , nullable = false)
	private Long id;
	
	@Column(name= "USER_FIRSTNAME" , updatable = true , insertable = true , nullable = false)
	private String firstName;
	
	@Column(name = "USER_LASTNAME" , updatable = true , insertable = true , nullable = false )
	private String lastname;
	
	@Column(name = "USER_EMAIL" , updatable = true, insertable = true ,  nullable =  false)
	private String email;
	
	@Column(name = "USER_TELEPHONE" , updatable = true, insertable = true ,  nullable =  true)
	private String telephone;
	
	
	@Column (name = "USER_PASSWORD" , updatable = true , insertable = true , nullable = false)
	private String password;
	
	
	// Role mapping ManyToMany 
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"),
	inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	public Set<Role> role = new HashSet<Role>();
	

	
	
	// Role mapping ManyToMany 
	@OneToOne(cascade = CascadeType.DETACH )
	@JoinTable(name = "HOTEL_MANAGE", joinColumns = @JoinColumn(name = "USER_ID"),
	inverseJoinColumns = @JoinColumn(name = "HOTEL_ID") )
	public Hotel hotel = new Hotel();
	
	
	// Generate Default const
	public User() {}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
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
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRole() {
		return role;
	}


	public void setRole(Set<Role> role) {
		this.role = role;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public User(Long id, String firstName, String lastname, String email, String telephone, String password,
			Set<Role> role, Hotel hotel) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.role = role;
		this.hotel = hotel;
	}


	public User(String firstName, String lastname, String email, String telephone, String password, Set<Role> role,
			Hotel hotel) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.role = role;
		this.hotel = hotel;
	}

}
