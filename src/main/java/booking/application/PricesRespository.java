package booking.application;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PricesRespository extends CrudRepository<Prices, Long> {

	
	
}
