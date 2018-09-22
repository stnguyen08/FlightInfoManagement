package cs544.flight.controller;

import cs544.flight.domain.Airline;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

public interface IAirlineController {


    public abstract List<Airline> getAll();

    public abstract String addBook(Airline airline);

    public  abstract String add(Airline airline) ;

    public abstract String get(int id) ;

    public abstract  String update(Airline airline, int id) ;

    public abstract String delete(int id) ;


}
