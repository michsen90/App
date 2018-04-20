package booking.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservations")
public class ReservationRestController {

	@Autowired
	private ReservationsRespository reservationRespository;
	
	@RequestMapping(value="/allreservations", method=RequestMethod.GET)
	public Iterable<Reservations> getAllReservations (){
		
		Iterable<Reservations> allReservations = reservationRespository.findAll();
		return allReservations;
	}
	
	@PostMapping(value="/saveReservation")
	public Response postReservation(@RequestBody Reservations reservation) {
		
		reservationRespository.save(reservation);
		Response response = new Response("Reservation has been added", reservation);
		return response;
	}
}
