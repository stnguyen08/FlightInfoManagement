package cs544.flight.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import cs544.flight.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cs544.flight.service.IFlightService;

@Controller
public class FlightController {

	@Autowired
	private IFlightService flightService;
	
	//@GetMapping(value="/home/index")
	@GetMapping(value="/")
	public ModelAndView flights() {
		ModelAndView mav = new ModelAndView();
		List<Flight> flights = flightService.findAll();
		//System.out.println("@@@@@@@ " + flights);
		mav.addObject("flights", flights);
		mav.setViewName("/home/index");
		return mav;
	}
	

	@GetMapping(value="/carowner/new")
	public String carOwnerRegistrationForm(Model model){
		//model.addAttribute("account", new Account());
		model.addAttribute("carOwner", new Flight());
		return "carowner/new";
	}

	@RequestMapping(value = "/carowner/new", method = RequestMethod.POST)
	public String registerNewStudent(@Valid @ModelAttribute("carOwner") Flight flight,
			//@Valid @ModelAttribute("account") Account account,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "carowner/new";
		}
		//System.out.println("@@@@@@ " + carOwner);
		flight = flightService.save(flight);
		//return "redirect:/srs/students/browse";
		return "redirect:/";
	}

	/*@RequestMapping(value="/srs/students/edit/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable Long id, Model model){
		Student s = studentService.findById(id);
		if (s != null) {
			model.addAttribute("student", s);
			return "students/edit";
		}
		return "students/browse";
	}

	@RequestMapping(value = "/srs/students/edit", method = RequestMethod.POST)
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
