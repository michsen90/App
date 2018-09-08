package booking.application.mvc;

import booking.application.Rooms;
import booking.application.RoomsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
public class Reservation {

    @Autowired
    private RoomsRespository roomsRespository;

    @GetMapping("/rezerwuj")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "/WEB-INF/jsp/rezerwacje.jsp";
    }

    @GetMapping("/sprawdz_rezerwacje")
    public String sprawdz_rezerwacje(
            @RequestParam(name = "data_przyjazdu") @DateTimeFormat(pattern="yyyy-MM-dd") Date data_przyjazdu,
            @RequestParam(name = "data_wyjazdu") @DateTimeFormat(pattern="yyyy-MM-dd") Date data_wyjazdu,
            @RequestParam(name = "ilosc_osob")  int ilosc_osob,
            Model model) {

        Iterable<Rooms> rooms = roomsRespository.findAll();
        model.addAttribute("pokoje",rooms);
        return "/WEB-INF/jsp/sprawdz_rezerwacje.jsp";
    }


}


