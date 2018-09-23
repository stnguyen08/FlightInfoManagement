package cs544.flight.controller;

import cs544.flight.domain.Airplane;
import cs544.flight.domain.SiteUrl;
import cs544.flight.model.FlightInfo;
import cs544.flight.service.IAirplaneService;
import cs544.flight.service.IFlightInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/airplane")
public class AirplaneController {

	@Autowired
	private IAirplaneService airplaneService;

	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	public String defaultPath() {
		return "redirect:/airplane/index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView aiplanes() {
		ModelAndView mav = new ModelAndView();
		List<Airplane> airplanes = airplaneService.findAll();
		mav.addObject("airplanes", airplanes);
//		mav.setViewName("/home/airplanes");
		return mav;
	}
	


	@GetMapping(value="/new")
	public String newAirplaneForm(Model model){
		model.addAttribute("airplane", new Airplane());
		return "/airplane/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addNewAirplane(@Valid @ModelAttribute("airplane") Airplane airplane,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/airplane/new";
		}
		airplane = airplaneService.save(airplane);
		//return "redirect:/srs/students/browse";
		return "redirect:/airplane";
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
