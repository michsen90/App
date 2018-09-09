package booking.application;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomsRespository extends CrudRepository<Rooms, Long>{

	
	/*@Query(value="SELECT ro from Rooms ro inner join ro.reservation r "
			+ "where not (r.startDate >= :start_date and r.finishDate <= :finish_date)")*/

	@Query("select ro from Rooms ro where ro.idRoom NOT IN(" +
            "select resroom.idRoom from Rooms resroom inner join resroom.reservation r" +
            " where (r.startDate <= :start_date and r.finishDate >= :start_date) OR " +
            "(r.startDate < :finish_date and r.finishDate >= :finish_date) OR "+
            "(:start_date <= r.startDate and :finish_date >= r.finishDate)" +
            ")")
    List <Rooms> freeRoomsJPQL(@Param("start_date")Date start_date, @Param("finish_date") Date finish_date);


    @Query(value="select * \n" +
			"	from rooms ro\n" +
			"	where ro.id_room not in(\n" +
			"		select ro.id_room\n" +
			"		from rooms ro\n" +
			"		join reservations r\n" +
			"		on ro.id_room = r.id_room\n" +
			"		where (r.start_date <= :start_date and r.finish_date >= :start_date)\n" +
			"		or (r.start_date < :finish_date and r.finish_date >= :finish_date)\n" +
			"		or (:start_date <= r.start_date and :finish_date >= r.finish_date)\n" +
			"\n" +
			"	);", nativeQuery=true)
	List <Rooms> freeRooms(@Param("start_date")Date start_date, @Param("finish_date") Date finish_date);

	
	/*select * 
	from rooms ro
	where ro.id_room not in(
		select ro.id_room
		from rooms ro
		join reservations r
		on ro.id_room = r.id_room
		where (r.start_date <= '2018-09-12' and r.finish_date >= '2018-09-12')
		or (r.start_date < '2018-09-14' and r.finish_date >= '2018-09-14')
		or ('2018-09-12' <= r.start_date and '2018-09-14' >= r.finish_date)

	);*/
}
