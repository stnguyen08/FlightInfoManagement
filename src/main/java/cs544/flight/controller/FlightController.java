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
	
	//@GetMapping(value="/home/index")
	@GetMapping(value={"/", "/home"})
	public ModelAndView flights() {
		ModelAndView mav = new ModelAndView();
		List<Flight> flights = flightService.findAll();
		//System.out.println("@@@@@@@ " + flights);
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
		System.out.println("@@@@@@ " + flight);
		System.out.println("@@@@@@ " + flight.getAirline());
		System.out.println("@@@@@@ " + flight.getAirplane());
		System.out.println("@@@@@@ " + flight.getOrigin());
		System.out.println("@@@@@@ " + flight.getDestination());
		flight = flightService.save(flight);
		//return "redirect:/srs/students/browse";
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

	//@PostMapping(value="/flight/{id}", params = "edit")
	@PostMapping(value="/flight")
	public String editFlight(@Valid @ModelAttribute("flight") Flight flight,
							 //@ModelAttribute("airline") Airline airline,
							 BindingResult bindingResult, Model model) {
//		System.out.println("@@@@@@@ Flight: " + flight);
//		System.out.println("@@@@@@@ Airline: " + flight.getAirline().getId() + ", " + flight.getAirline().getName());
//		System.out.println("@@@@@@@ Airplane: " + flight.getAirplane().getId() + ", " + flight.getAirplane().getSerialNumber());
		//System.out.println("@@@@@@@ Departure: " + flight.getOrigin());
//		System.out.println("@@@@@@@ Departure: " + flight.getOrigin().getId() + ", " + flight.getOrigin().getName());
//		System.out.println("@@@@@@@ Destination: " + flight.getDestination().getId() + ", " + flight.getDestination().getName());
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/flight/edit";
		}
		this.flightService.save(flight); // flight.id already set by binding
		return "redirect:/";
	}

	/*@RequestMapping(value = "/srs/students/edit", method = RequestMethod.POST)
	public String updateStudent(@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "students/edit";
		}
		student = studentService.save(student);
		return "redirect:/srs/students/browse";
	}*/
}
