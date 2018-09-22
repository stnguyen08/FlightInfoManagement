package cs544.flight.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import cs544.flight.model.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cs544.flight.service.IFlightInfoService;

@Controller
public class FlightController {

	@Autowired
	private IFlightInfoService flightInfoService;
	
	//@RequestMapping(value="/srs/students/browse", method=RequestMethod.GET)
	@RequestMapping(value="/home/index", method=RequestMethod.GET)
	public ModelAndView students() {
		ModelAndView mav = new ModelAndView();
		//List<Student> students = studentService.findAll();
		List<FlightInfo> flights = new ArrayList<>();
		flights.add(new FlightInfo());
		flights.add(new FlightInfo());
		mav.addObject("flights", flights);
		//mav.setViewName("/home/index");
		return mav;
	}
	
	/*@GetMapping(value="/carowner/sign")
	public String carOwnerSignInForm(Model model){
		model.addAttribute("account", new Account());
		return "carowner/sign";
	}*/

	@GetMapping(value="/carowner/new")
	public String carOwnerRegistrationForm(Model model){
		//model.addAttribute("account", new Account());
		model.addAttribute("carOwner", new FlightInfo());
		return "carowner/new";
	}

	@RequestMapping(value = "/carowner/new", method = RequestMethod.POST)
	public String registerNewStudent(@Valid @ModelAttribute("carOwner") FlightInfo carOwner,
			//@Valid @ModelAttribute("account") Account account,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "carowner/new";
		}
		//System.out.println("@@@@@@ " + carOwner);
		carOwner = flightInfoService.save(carOwner);
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
