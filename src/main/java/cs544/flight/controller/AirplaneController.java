package cs544.flight.controller;

import cs544.flight.domain.Airplane;
import cs544.flight.service.AirplaneService;
import cs544.flight.service.IAirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AirplaneController {

    @Autowired
    private IAirplaneService airplaneService;

    @RequestMapping(value = "/airplanes", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("airplanes", airplaneService.getAll());
        return "airplanesList";
    }

    @RequestMapping(value = "/airplane/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("airplane", this.airplaneService.get(id));
        return "airplaneDetail";
    }

    @RequestMapping(value = "/airplanes/{id}", method = RequestMethod.POST)
    public String update(@Valid Airplane airplane, BindingResult result,
                         @PathVariable int id) {
        if (!result.hasErrors()) {
            this.airplaneService.save(airplane); // airline.id already set by binding
            return "redirect:/airplanes";
        } else {
            return "airplaneDetail";
        }
    }

    @RequestMapping(value = "/airplanes/delete", method = RequestMethod.POST)
    public String delete(int airlineId) {
        this.airplaneService.delete(airlineId);
        return "redirect: /airplanes";
    }

}
