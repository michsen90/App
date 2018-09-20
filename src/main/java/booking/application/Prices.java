package booking.application;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@EnableAutoConfiguration
@Table(name="prices")
public class Prices implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE3")
	@SequenceGenerator(name="SEQUENCE3", sequenceName="prices_id_price_seq", allocationSize=1)
	@Column(name="id_price")
	private Long idPrice;
	
	@Column(name="price_per_day")
	private int pricePerDay;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_room")
	@JsonBackReference
	private Rooms room;
	
	protected Prices() {}
	
	public Prices(Long idPrice, int pricePerDay, Rooms room) {
		this.idPrice = idPrice;
		this.pricePerDay = pricePerDay;
		this.room = room;
	}
	
	@Override
	public String toString() {
		
		return String.format("Price[id=$d, pricePerDay=%d, room=%d]", idPrice, pricePerDay, room);
	}

	public Long getIdPrice() {
		return idPrice;
	}

	public void setIdPrice(Long idPrice) {
		this.idPrice = idPrice;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
}
