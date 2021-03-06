package cs544.flight.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import cs544.flight.domain.Airline;
import cs544.flight.domain.Airplane;
import cs544.flight.domain.Airport;
import cs544.flight.domain.Flight;
import cs544.flight.service.IAirlineService;
import cs544.flight.service.IAirplaneService;
import cs544.flight.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cs544.flight.service.IFlightService;

@Controller
public class FlightController {

	@Autowired
	private IFlightService flightService;

	@Autowired
	private IAirportService airportService;

	@Autowired
	private IAirlineService airlineService;

	@Autowired
	private IAirplaneService airplaneService;
	
	@GetMapping(value={"/", "/home"})
	public ModelAndView flights() {
		ModelAndView mav = new ModelAndView();
		List<Flight> flights = flightService.findAll();
		mav.addObject("flights", flights);
		mav.setViewName("/home/index");
		return mav;
	}

	@GetMapping(value="/flight/new")
	public String newFlightForm(Model model){
		model.addAttribute("flight", new Flight());
		model.addAttribute("airlines", airlineService.findAll());
		model.addAttribute("airplanes", airplaneService.findAll());
		model.addAttribute("airports", airportService.findAll());
		return "/flight/new";
	}

	@RequestMapping(value = "/flight/new", method = RequestMethod.POST)
	public String scheduleNewFlight(@Valid @ModelAttribute("flight") Flight flight,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/flight/new";
		}
		flight = flightService.save(flight);
		return "redirect:/";
	}

	@GetMapping(value="/flight/{id}")
	public String get(@PathVariable Integer id, Model model){
		Flight flight = flightService.findOne(id);
		List<Airline> airlines = airlineService.findAll();
		model.addAttribute("airlines", airlines);
		List<Airplane> airplanes = airplaneService.findAll();
		model.addAttribute("airplanes", airplanes);
		List<Airport> airports = airportService.findAll();
		model.addAttribute("airports", airports);

		if (flight != null) {
			model.addAttribute("flight", flight);
			return "flight/edit";
		}
		return "/";
	}

	@PostMapping(value="/flight")
	public String editFlight(@Valid @ModelAttribute("flight") Flight flight,
							 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/flight/edit";
		}
		this.flightService.save(flight); // flight.id already set by binding
		return "redirect:/";
	}

	// Only search by departure date
	@PostMapping(value = "/flight/search")
	public ModelAndView defaultSearchForFlights(@RequestParam String criteria) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("flights", flightService.search(criteria));
		mav.setViewName("/flight/search");
		return mav;
	}
}
