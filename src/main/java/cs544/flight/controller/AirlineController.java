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
public class AirlineController{

    @Autowired
    private IAirlineService airlineService;

    @GetMapping(value="/airlineList")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airline> airlines = airlineService.getAll();

        mav.addObject("airlines", airlines);
        mav.setViewName("/airline/index");
        return mav;
    }

    @GetMapping(value = "/airline/{id}")
    public ModelAndView get(@PathVariable int id, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("airline", this.airlineService.get(id));
        mav.setViewName("/airline/detail");
        return mav;
    }

    @PostMapping(value = "/airlines/{id}")
    public ModelAndView update(@Valid Airline airline, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        //String viewName="airline/";


       // if (!result.hasErrors()) {
            this.airlineService.save(airline); // airline.id already set by binding
            //mav.setViewName("/airlineList");
            //viewName = "redirect: /airlineList";
      //  }
        mav.setViewName("redirect:/airlineList");
        return mav;


    }

    @RequestMapping(value = "/addAirline", method = RequestMethod.GET)
    public String addAirline(@ModelAttribute("airline") Airline airline) {
        return "addAirline";
    }

    @RequestMapping(value = "/airlines/delete", method = RequestMethod.POST)
    public String delete(int airlineId) {
        this.airlineService.delete(airlineId);
        return "redirect: /airlines";
    }

}
