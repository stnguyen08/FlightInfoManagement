package cs544.flight.controller;

import cs544.flight.domain.Airplane;
import cs544.flight.domain.Airport;
import cs544.flight.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/airport")
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @RequestMapping(value={"", "/"}, method=RequestMethod.GET)
    public String defaultPath() {
        return "redirect:/airport/index";
    }

    @GetMapping(value="/index")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airport> airports = airportService.findAll();

        mav.addObject("airports", airports);
        mav.setViewName("/airport/index");
        return mav;
    }

    @GetMapping(value="/new")
	public String newAirplaneForm(Model model){
		model.addAttribute("airport", new Airport());
		return "/airport/new";
	}

	@PostMapping(value = "/new")
	public String addNewAirplane(@Valid @ModelAttribute("airport") Airport airport,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/airport/new";
		}
		airport = airportService.save(airport);
		return "redirect:/airport";
	}

    @GetMapping(value = "/{id}")
    public ModelAndView get(@PathVariable int id, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("airport", this.airportService.findOne(id));
        mav.setViewName("/airport/detail");
        return mav;
    }

    @PostMapping(value = "/{id}", params = "update")
    public String update(@Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airport/" + airport.getId();
        }
        this.airportService.save(airport); // airport.id already set by binding

        return "redirect:/airport";
    }

    @PostMapping(value = "/{id}", params = "delete")
    public String delete(@PathVariable int id) {
        this.airportService.delete(id);
        return "redirect:/airport";
    }
}
