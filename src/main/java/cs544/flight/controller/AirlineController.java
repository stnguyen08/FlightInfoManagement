package cs544.flight.controller;

import cs544.flight.domain.Airline;
import cs544.flight.persistence.IAirlinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public class AirlineController implements IAirlineController {

    @Autowired
    private IAirlinePersistence airlinePersistence;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/airlines", method = RequestMethod.GET)
    public List<Airline> getAll(Model model) {
        model.addAttribute("airlines", airlinePersistence.getAll());
        return "airlines";
    }

    @Override
    public String addBook(Airline book) {
        return null;
    }

    @Override
    public String add(Airline book, BindingResult result, RedirectAttributes re) {
        return null;
    }

    @Override
    public String get(int id, Model model) {
        return null;
    }

    @Override
    public String update(Airline book, BindingResult result, int id) {
        return null;
    }

    @Override
    public String delete(int bookId) {
        return null;
    }
}
