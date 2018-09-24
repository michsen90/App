package booking.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReservationsRespository extends CrudRepository<Reservations, Long>{

	List<Reservations> findRservationsByClient(Clients client);
}
