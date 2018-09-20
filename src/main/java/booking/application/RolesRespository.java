package booking.application;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolesRespository extends CrudRepository<Roles, Long>{

	Roles findByAccount(Accounts a);
	
}
