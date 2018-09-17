package booking.application.mvc;

import booking.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class ReservationController {

	
	
    @Autowired
    private RoomsRespository roomsRespository;

    @Autowired
    private ReservationsRespository reservations;

    @Autowired
    private ClientsRespository clientsRepository;

    @Autowired
    private AccountsRespository accountsRespository;
    
    @Autowired
    private PricesRespository pricesRespository;


    private Clients getLoggedClient(HttpServletRequest request) {
    	
    	String login = request.getUserPrincipal().getName();
         Iterable<Accounts> accounts = accountsRespository.findByLogin(login);
         Clients aktualny_client = null;
         for (Accounts ac : accounts) {
             aktualny_client = ac.getClient();
         }
         return aktualny_client;
    }
    
    @GetMapping("/rezerwuj")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "/WEB-INF/jsp/rezerwacje.jsp";
    }

    @GetMapping("/sprawdz_rezerwacje")
    public String sprawdz_rezerwacje(
            HttpSession session,
            @RequestParam(name = "data_przyjazdu") @DateTimeFormat(pattern="yyyy-MM-dd") Date data_przyjazdu,
            @RequestParam(name = "data_wyjazdu") @DateTimeFormat(pattern="yyyy-MM-dd") Date data_wyjazdu,
            @RequestParam(name = "ilosc_osob")  int ilosc_osob,
            Model model) {

        session.setAttribute("data_przyjazdu",data_przyjazdu);
        session.setAttribute("data_wyjazdu", data_wyjazdu);
        Iterable<Rooms> rooms = roomsRespository.freeRoomsJPQL(data_przyjazdu, data_wyjazdu);
        model.addAttribute("pokoje",rooms);
        return "/WEB-INF/jsp/sprawdz_rezerwacje.jsp";
    }

    @GetMapping("/rezerwuj_pokoj")
    public String rezerwuj_pokoj(HttpServletRequest request,
            HttpSession session, @RequestParam(name = "pokoj")  long nr_pokoju,
            Model model) {

        Date data_przyjazdu  = (Date)session.getAttribute("data_przyjazdu");
        Date data_wyjazdu  = (Date)session.getAttribute("data_wyjazdu");
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-DD");

        Clients aktualny_client = getLoggedClient(request);
        Rooms room = roomsRespository.findOne(nr_pokoju);
        Reservations rezerwacja = new Reservations(data_przyjazdu, data_wyjazdu, aktualny_client, room);

        reservations.save(rezerwacja);
        String message="success \n" +formatter.format(data_przyjazdu) +"\n"+formatter.format(data_wyjazdu)+"\n"+nr_pokoju;
        session.removeAttribute("data_przyjazdu");
        session.removeAttribute("data_wyjazdu");
        model.addAttribute("wiadomosc",message);
        return "/WEB-INF/jsp/potwierdzenie.jsp";
    }
    
    @GetMapping("/showdata")
	public String checkClientData(HttpServletRequest request, 
			@RequestParam(name = "edit", required=false, defaultValue="false")  String edit,
			Model model) {
		
    	String page = "/WEB-INF/jsp/showdata.jsp";
		Clients c = getLoggedClient(request);
		model.addAttribute("dane", c);
		if (!"false".equals(edit)) {			
			page = "/WEB-INF/jsp/editClient.jsp";			
		}
		
		return page;
	}
	

	@GetMapping("/editClient")
	public String updatingClient(@RequestParam(name="id") int id, @RequestParam(name="firstname")String firstname, 
			@RequestParam(name="lastname") String lastname,
			@RequestParam(name="email") String email, @RequestParam(name="city") String city,
			@RequestParam(name="street")String street, @RequestParam(name="number")String number,
			@RequestParam(name="phone") String phone, HttpServletRequest request, Model model) {
		
		Clients aktualny_client = getLoggedClient(request);
		aktualny_client.setFirstname(firstname);
		aktualny_client.setLastname(lastname);
		aktualny_client.setEmail(email);
		aktualny_client.setCity(city);
		aktualny_client.setStreet(street);
		aktualny_client.setNumber(number);
		aktualny_client.setPhone(phone);
		clientsRepository.save(aktualny_client);
		model.addAttribute("dane", aktualny_client);
		model.addAttribute("message", "Dane zaktualizowane w systemie");
		return "/WEB-INF/jsp/showdata.jsp";
	}
	
	@GetMapping("/deleteClient")
	public String deleteClient(HttpServletRequest request, Model model) {
		
		Clients aktualny_client = getLoggedClient(request);
		clientsRepository.delete(aktualny_client);
		return "/WEB-INF/jsp/clientDeleted.jsp";
	}
	
	@GetMapping("/cennik")
	public String pricesforRooms(Model model) {
		
		Iterable<Prices> p = pricesRespository.findAll();
		System.out.println(p);
		model.addAttribute("prices", p);
		return "/WEB-INF/jsp/prices.jsp";
		
		
	}
}


