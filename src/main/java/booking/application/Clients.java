package booking.application;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@EnableAutoConfiguration
@Table(name="clients")
public class Clients implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="clients_id_client_seq", allocationSize=1)
	@Column(name="id_client")
	private Long idClient;
	
	@Column(name="firstname")
	@Size(min=3, max=20)
	@NotNull
	private String firstname;
	
	@Column(name="lastname")
	@Size(min=3, max=20)
	@NotNull
	private String lastname;
	
	@Column(name="email")
	@NotNull
	@Email
	private String email;
	
	@Column(name="city")
	@NotNull
	private String city;
	
	@Column(name="street")
	@NotNull
	private String street;
	
	@Column(name="number")
	@NotNull
	private String number;
	
	@Column(name="phone")
	@NotNull
	private String phone;
	
	@OneToMany(mappedBy="client")
	@JsonManagedReference(value="reservations")
	private List<Reservations> reservation;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="client")
	@JsonManagedReference(value="accounts")
	private Accounts account;
	
	protected Clients() {}
	
	public Clients(Long idClient, String firstname, String lastname, String email, String city, String street, String number, String phone) {
		
	
		this.idClient = idClient;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.city = city;
		this.street = street;
		this.number = number;
		this.phone = phone;
	}
	
	@Override
	public String toString () {
		
		return String.format("Client [id = %d, firstname = '%s', lastname = '%s', email='%s', city='%s', street='%s', number = '%s', phone = '%s']", 
				+ idClient, firstname, lastname, email, city, street, number, phone);
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Reservations> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservations> reservation) {
		this.reservation = reservation;
	}
	
	
}
