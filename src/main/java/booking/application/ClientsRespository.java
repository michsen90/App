package booking.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClientsRespository extends CrudRepository<Clients, Long> {

	Iterable<Clients> findByFirstname(String firstname);
	
 }
