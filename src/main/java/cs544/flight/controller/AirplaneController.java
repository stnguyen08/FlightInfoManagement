package cs544.flight.controller;

import cs544.flight.domain.Airline;
import cs544.flight.repository.AirlinePersistence;
import cs544.flight.repository.IAirlinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AirplaneController {

    @Autowired
    private IAirlinePersistence airlinePersistence;

    public void setAirlinePersistence(AirlinePersistence airlinePersistence) {
        this.airlinePersistence = airlinePersistence;
    }

    public AirplaneController() {

    }

    @RequestMapping(value = "/airlines", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("airlines", airlinePersistence.getAll());
        return "airlinesList";
    }

    @RequestMapping(value = "/addAirline", method = RequestMethod.GET)
    public String addAirline(@ModelAttribute("airline") Airline airline) {
        return "addAirline";
    }

//    @RequestMapping(value = "/addAirline", method = RequestMethod.POST)
//    public String add(@Valid Airline airline, BindingResult result, RedirectAttributes re) {
//        String view = "redirect:/airlines";
//        if (!result.hasErrors()) {
//            this.airlinePersistence.add(airline);
//        } else {
//            // TODO check if we can make it work with redirect
//            view = "addAirline";
//        }
//        return view;
//    }

    @RequestMapping(value = "/airline/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("airline", this.airlinePersistence.get(id));
        return "airlineDetail";
    }

    @RequestMapping(value = "/airlines/{id}", method = RequestMethod.POST)
    public String update(@Valid Airline airline, BindingResult result,
                         @PathVariable int id) {
        if (!result.hasErrors()) {
            this.airlinePersistence.update(id, airline); // airline.id already set by binding
            return "redirect:/airlines";
        } else {
            return "airlineDetail";
        }
    }

    @RequestMapping(value = "/airlines/delete", method = RequestMethod.POST)
    public String delete(int airlineId) {
        this.airlinePersistence.delete(airlineId);
        return "redirect: /airlines";
    }

}
