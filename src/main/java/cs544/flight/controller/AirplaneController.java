package cs544.flight.controller;

import cs544.flight.domain.Airplane;
import cs544.flight.service.IAirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping(value="/index")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airplane> airplanes = airplaneService.findAll();

        mav.addObject("airplanes", airplanes);
        mav.setViewName("/airplane/index");
        return mav;
    }

    @GetMapping(value="/new")
	public String newAirplaneForm(Model model){
		model.addAttribute("airplane", new Airplane());
		return "/airplane/new";
	}

	@PostMapping(value = "/new")
	public String addNewAirplane(@Valid @ModelAttribute("airplane") Airplane airplane,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/airplane/new";
		}
		airplane = airplaneService.save(airplane);
		return "redirect:/airplane";
	}

    @GetMapping(value = "/{id}")
    public ModelAndView get(@PathVariable int id, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("airplane", this.airplaneService.findOne(id));
        mav.setViewName("/airplane/detail");
        return mav;
    }

    @PostMapping(value = "/{id}", params = "update")
    public String update(@Valid @ModelAttribute("airplane") Airplane airplane, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airplane/detail";
        }
        this.airplaneService.save(airplane); // airline.id already set by binding

        return "redirect:/airplane";
    }

    @PostMapping(value = "/{id}", params = "delete")
    public String delete(@PathVariable int id) {
        this.airplaneService.delete(id);
        return "redirect:/airplane";
    }
}
