package booking.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientsRestController {

	@Autowired
	private ClientsRespository clientsRespository;
	
	@RequestMapping(value="/allclients", method=RequestMethod.GET)
	public Iterable<Clients> AllClients(){
		
		Iterable<Clients> allClients = clientsRespository.findAll();
		return allClients;
	}
	
	@PostMapping(value="/saveClient")
	public Response postClient(@RequestBody Clients client) {
		
		clientsRespository.save(client);
		Response response = new Response("Done", client);
		return response;
	}
	
}
