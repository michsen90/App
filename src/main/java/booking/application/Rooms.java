package booking.application;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;



@Entity
@EnableAutoConfiguration
@Table(name="rooms")
public class Rooms {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE5")
	@SequenceGenerator(name="SEQUENCE5", sequenceName="rooms_id_room_seq", allocationSize=1)
	@Column(name="id_room")
	private Long idRoom;
	@Column(name="room_type")
	private String roomType;
	@Column(name="balcone")
	private String balcone;
	@Column(name="floor")
	private String floor;
	@Column(name="family_room")
	private String familyRoom;
	@Column(name="animals")
	private String animals;
	@Column(name="people_can_book")
	private int peopleCanBook;
	
	@OneToMany(mappedBy="room")
	private List<Prices> price;
	
	@OneToMany(mappedBy="room")
	private List<Reservations> reservation;
	
	protected Rooms() {}
	
	public Rooms(Long idRoom, String roomType, String balcone, String floor, 
			String familyRoom, String animals, int peopleCanBook) {
		
	
		this.idRoom = idRoom;
		this.roomType = roomType;
		this.balcone = balcone;
		this.floor = floor;
		this.familyRoom = familyRoom;
		this.animals = animals;
		this.peopleCanBook = peopleCanBook;
	}
	
	@Override
	public String toString() {
		
		return String.format("Room[id=%d, roomType='%s', balcone='%s', floor='%s', familyRoom='%s', animals='%s', peopleCanBook='%s']", 
				+ idRoom, roomType, balcone, floor, familyRoom, animals, peopleCanBook);
				
	}

	public Long getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBalcone() {
		return balcone;
	}

	public void setBalcone(String balcone) {
		this.balcone = balcone;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	

	public int getPeopleCanBook() {
		return peopleCanBook;
	}

	public void setPeopleCanBook(int peopleCanBook) {
		peopleCanBook = peopleCanBook;
	}

	public List<Prices> getPrice() {
		return price;
	}

	public void setPrice(List<Prices> price) {
		this.price = price;
	}

	public List<Reservations> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservations> reservation) {
		this.reservation = reservation;
	}

	public String getFamilyRoom() {
		return familyRoom;
	}

	public void setFamilyRoom(String familyRoom) {
		this.familyRoom = familyRoom;
	}

	public String getAnimals() {
		return animals;
	}

	public void setAnimals(String animals) {
		this.animals = animals;
	}
	
	
}
