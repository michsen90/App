package booking.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountsRestController {

	@Autowired
	private AccountsRespository accountsRespository;
	
	@Autowired
	private ClientsRespository clientRespository;
	
	@RequestMapping(value="/allaccounts", method=RequestMethod.GET)
	public Iterable<Accounts> getAccounts(){
		
		Iterable<Accounts> allAccounts = accountsRespository.findAll();
		return allAccounts;
	}
	
	@PostMapping(value="/saveAccount")
	public Response postAccount(@RequestBody Accounts account) {
		
		System.out.println("Post account started");
		clientRespository.save(account.getClient());
		System.out.println("client saved");
		accountsRespository.save(account);
		System.out.println("account saved");
		Response response = new Response("Done", account);
		System.out.println("Preparing response");
		return response;
	}
	
	
	
}
