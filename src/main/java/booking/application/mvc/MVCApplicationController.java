package booking.application.mvc;

import booking.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.sym.Name;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MVCApplicationController {

	
	
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
    
    @Autowired
    private RolesRespository rolesRespository;


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
    public String rezerwacja(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "/WEB-INF/jsp/rezerwacje.jsp";
    }

    @GetMapping("/sprawdz_rezerwacje")
    public String checkFreeRooms(
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
    public String makeResevation(HttpServletRequest request,
            HttpSession session, @RequestParam(name = "pokoj")  long nr_pokoju,
            Model model) {

        Date data_przyjazdu  = (Date)session.getAttribute("data_przyjazdu");
        Date data_wyjazdu  = (Date)session.getAttribute("data_wyjazdu");
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-DD");

        Clients aktualny_client = getLoggedClient(request);
        Rooms room = roomsRespository.findOne(nr_pokoju);
        Reservations rezerwacja = new Reservations(data_przyjazdu, data_wyjazdu, aktualny_client, room);

        reservations.save(rezerwacja);
        String message="Twoja rezerwacja zostala przyjeta. Termin:  \n " +formatter.format(data_przyjazdu) +"\n " + formatter.format(data_wyjazdu) + "\n numer pokoju: " + nr_pokoju;
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
	
	@GetMapping("/cennik")
	public String pricesforRooms(Model model) {
		
		Iterable<Prices> p = pricesRespository.findAll();
		System.out.println(p);
		model.addAttribute("prices", p);
		return "/WEB-INF/jsp/prices.jsp";
		
		
	}
	@GetMapping("/decide")
	public String adminHomePage(HttpServletRequest request, Model model) {
		
		String page = "/WEB-INF/jsp/index.jsp";
		String login = request.getUserPrincipal().getName();
		Accounts account = accountsRespository.findAccountByLogin(login);
		Roles role = rolesRespository.findByAccount(account);
		String admin = "ADMIN";
		
		if(admin.equals(role.getRole())) {
			page = "/WEB-INF/jsp/admin/details.jsp";
		}
		model.addAttribute("role", role);
		
		
		return page;
	}
	
	@GetMapping("/aacounts")
	public String adminAccounts(HttpServletRequest request, Model model) {
		
		Iterable<Accounts> accounts = accountsRespository.findAll();
		model.addAttribute("accounts", accounts);
		return "/WEB-INF/jsp/admin/aacounts.jsp";
	}
	@GetMapping("/arooms")
	public String adminRooms(HttpServletRequest request, Model model) {
		
		String page = "/WEB-INF/jsp/admin/arooms.jsp";
		Iterable<Prices> prices = pricesRespository.findAll();
		model.addAttribute("rooms", prices);
		
		return page;
	}
	@GetMapping("/aeditingRooms")
	public String adminEditRooms(HttpServletRequest request, Model model, HttpSession session, 
			@RequestParam(name="id") Long id) {
		
		session.setAttribute("id", id);
		Prices p = pricesRespository.findOne(id);
		model.addAttribute("room", p);
		return "/WEB-INF/jsp/admin/aeditingRooms.jsp";
	}
	
	@GetMapping("/achangedroom")
	public String adminChangedRoom(HttpServletRequest request, Model model, HttpSession session, 
			@RequestParam(name="id") Long id,  @RequestParam(name="type_room") String roomType, @RequestParam(name="balcone")
			String balcone, @RequestParam(name="floor") String floor, @RequestParam(name="family_room") String familyRoom, 
			@RequestParam(name="animals") String animals, @RequestParam(name="price_per_day")
			int pricePerDay) {
		
		session.setAttribute("id", id);
		Prices p = pricesRespository.findOne(id);
		p.getRoom().setRoomType(roomType);
		p.getRoom().setBalcone(balcone);
		p.getRoom().setFloor(floor);
		p.getRoom().setFamilyRoom(familyRoom);
		p.getRoom().setAnimals(animals);
		p.setPricePerDay(pricePerDay);
		pricesRespository.save(p);
		String m = "Dane pokoju zostaly zaktualizowane";
		model.addAttribute("room", p).addAttribute("m", m);
		return "/WEB-INF/jsp/admin/achangedroom.jsp";
	}
	
	@GetMapping("addingnewroom")
	public String addingNewRooms(Model model, HttpServletRequest request) {
		
		String m = "Dodajesz nowy pokoj";
		model.addAttribute("m", m);
		return"/WEB-INF/jsp/admin/aaddRoom.jsp";
	}
	
	@GetMapping("aaddRoom")
	public String addRoom(HttpServletRequest request, Model model, @RequestParam(name="type_room") String roomType,
			@RequestParam(name="balcone") String balcone, @RequestParam(name="floor") String floor,
			@RequestParam(name="family_room") String familyRoom, 
			@RequestParam(name="animals") String animals, @RequestParam(name="price_per_day") int pricePerDay) {
		
		Rooms r = new Rooms(null, roomType, balcone, floor, familyRoom, animals);
		Prices p = new Prices(null, pricePerDay, r);
		pricesRespository.save(p);
		String m = "Nowy pokoj zostal dodany";
		model.addAttribute("room", p).addAttribute("m", m);
		return"/WEB-INF/jsp/admin/addedRoom.jsp";
	}
	@GetMapping("deletingRoom")
	public String adeleteRoom(HttpServletRequest request, Model model) {
		
		Iterable<Prices> prices = pricesRespository.findAll();
		model.addAttribute("rooms", prices);
		return "/WEB-INF/jsp/admin/adeleteRoom.jsp";
	}
	@GetMapping("adeleteroom")
	public String adeletedRoom(HttpServletRequest request, Model model, HttpSession session,
			@RequestParam(name="id") Long id) {
		
		session.setAttribute("id", id);
		Prices p = pricesRespository.findOne(id);
		pricesRespository.delete(p);
		String m = "Pokoj zostal usuniety";
		model.addAttribute("room", p).addAttribute("m", m);
		return "/WEB-INF/jsp/admin/aroomdeleted.jsp";
	}
	
	
	@GetMapping("/areservations")
	public String adminReservations(Model model) {
		
		Iterable<Reservations> r = reservations.findAll();
		model.addAttribute("reservation", r);
		return "/WEB-INF/jsp/admin/areservations.jsp";
	}
	
	
	
	
	
	
	
}


