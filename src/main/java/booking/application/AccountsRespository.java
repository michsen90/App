package booking.application;

import org.springframework.data.repository.CrudRepository;

public interface AccountsRespository extends CrudRepository<Accounts, Long> {

	Iterable<Accounts> findByLogin(String login);
}
