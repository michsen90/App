package booking.application;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@EnableAutoConfiguration
@Table(name="reservations")
public class Reservations {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE4")
	@SequenceGenerator(name="SEQUENCE4", sequenceName="reservations_id_reservation_seq", allocationSize=1)
	@Column(name="id_reservation")
	@NotNull
	private Long idReservation;
	@Column(name="start_date")
	@NotNull
	private Date startDate;
	@Column(name="finish_date")
	@NotNull
	private Date finishDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client")
	@JsonBackReference(value="reservations")
	private Clients client;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_room")
	@JsonBackReference
	private Rooms room;
	
	protected Reservations() {}
	
	public Reservations(Long idReservation, Date startDate, Date finishDate, Clients client, Rooms room) {
		
		this.idReservation = idReservation;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.client = client;
		this.room = room;
	}
	
	@Override
	public String toString() {
		
		return String.format("Reservation[id=%d, startDate='%s', finishDate='%s', client=%d, room=%d]", 
				+ idReservation, startDate, finishDate );
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	
	
}
