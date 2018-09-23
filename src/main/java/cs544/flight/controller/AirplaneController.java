package cs544.flight.controller;

import cs544.flight.domain.Airline;
import cs544.flight.domain.Airplane;
import cs544.flight.service.AirplaneService;
import cs544.flight.service.IAirlineService;
import cs544.flight.service.IAirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AirplaneController {

    @Autowired
    private IAirplaneService airplaneService;

    @GetMapping(value="/airplaneList")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airplane> airplanes = airplaneService.getAll();

        mav.addObject("airplanes", airplanes);
        mav.setViewName("/airplane/index");
        return mav;
    }

    @GetMapping(value = "/airplane/{id}")
    public ModelAndView get(@PathVariable int id, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("airplane", this.airplaneService.get(id));
        mav.setViewName("/airplane/detail");
        return mav;
    }

    @PostMapping(value = "/airplanes/{id}")
    public ModelAndView update(@Valid Airplane airplane, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        //String viewName="airplane/";


        // if (!result.hasErrors()) {
        this.airplaneService.save(airplane); // airline.id already set by binding
        //mav.setViewName("/airplaneList");
        //viewName = "redirect: /airplaneList";
        //  }
        mav.setViewName("redirect:/airplaneList");
        return mav;


    }

    @RequestMapping(value = "/airplane", method = RequestMethod.GET)
    public String addAirline(@ModelAttribute("airplane") Airplane airplane) {
        return "addAirplane";
    }

    @RequestMapping(value = "/airplanes/delete", method = RequestMethod.POST)
    public String delete(int airplaneId) {
        this.airplaneService.delete(airplaneId);
        return "redirect: /airplaneList";
    }

}
