package cs544.flight.controller;

import cs544.flight.domain.Airline;


import cs544.flight.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/airline")
public class AirlineController{

    @Autowired
    private IAirlineService airlineService;

    @RequestMapping(value={"", "/"}, method=RequestMethod.GET)
    public String defaultPath() {
        return "redirect:/airline/index";
    }

    @GetMapping(value = "/index")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airline> airlines = airlineService.findAll();
        mav.addObject("airlines", airlines);
        mav.setViewName("/airline/index");
        return mav;
    }

    @GetMapping(value = "/new")
    public String newAirlineForm(@Valid @ModelAttribute("airline") Airline airline) {
        return "/airline/new";
    }

    @PostMapping(value = "/new")
    public String addNewAirplane(@Valid @ModelAttribute("airplane") Airline airline,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airplane/new";
        }
        airline = airlineService.save(airline);
        return "redirect:/airline";
    }

    @GetMapping(value = "/{id}")
    public ModelAndView get(@PathVariable int id, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("airline", this.airlineService.findOne(id));
        mav.setViewName("/airline/detail");
        return mav;
    }

    @PostMapping(value = "/{id}", params = "update")
    public String update(@Valid @ModelAttribute("airline")  Airline airline, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airline/" + airline.getId();
        }

        this.airlineService.save(airline); // airline.id already set by binding
        return "redirect:/airline";
    }

    @PostMapping(value = "/{id}", params = "delete")
    public String delete(@PathVariable int id) {
        this.airlineService.delete(id);
        return "redirect:/airline";
    }

}
