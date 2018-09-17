package booking.application;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PricesRespository extends CrudRepository<Prices, Long> {

	@Query("Select r.roomType, p.pricePerDay from Rooms r inner join r.price p where "
			+ "r.idRoom = p.room")
	List<Prices> pricesJPQL();
	@Query(value="(select r.room_type, p.price_per_day \n" + 
			"from rooms r inner join prices p \n" + 
			"on r.id_room = p.id_room);", nativeQuery=true)
	List<Prices> prices();
	
	
	/*select r.room_type, p.price_per_day 
from rooms r join prices p
on r.id_room = p.id_room*/
}
