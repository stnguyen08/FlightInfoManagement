package cs544.flight.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cs544.flight.domain.Flight;
import cs544.flight.repository.FlightRepository;
import cs544.flight.repository.FlightSpecification;
import cs544.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FlightService implements IFlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> findAll() {
        //return flightRepository.findAll();
        return flightRepository.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight findOne(Integer id) {
        return flightRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        flightRepository.delete(id);
    }

    @Override
    public List<Flight> search(String criteria) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        String[] str = criteria.split(";");

        String flightnr = null;
        Date departureDate = null;
        Date departureTime = null;
        Date arrivalDate = null;
        Date arrivalTime = null;

        Specification<Flight> flightSpec = null;

        for (String c : str) {
            String token = c.substring(0, c.indexOf("="));
            System.out.println(c);
            switch (token) {
                case "F": {
                    flightnr = c.substring(c.indexOf("=") + 1);
                    System.out.println(flightnr);
                    if(!flightnr.isEmpty()) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.flightNr(flightnr);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.flightNr(flightnr));
                        }
                    }
                    break;
                }
                case "DD": {
                    departureDate = parseDate(c.substring(c.indexOf("=") + 1));
                    if(departureDate != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.departureDate(departureDate);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.departureDate(departureDate));
                        }
                    }
                    break;
                }
                case "DT=": {
                    departureTime = parseTime(c.substring(c.indexOf("=") + 1));
                    if(departureTime != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.departureTime(departureTime);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.departureTime(departureTime));
                        }
                    }
                    break;
                }
                case "AD": {
                    arrivalDate = parseDate(c.substring(c.indexOf("=") + 1));
                    if(arrivalDate != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.arrivalDate(arrivalDate);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.arrivalDate(arrivalDate));
                        }
                    }
                    break;
                }
                case "AT=": {
                    arrivalTime = parseTime(c.substring(c.indexOf("=") + 1));
                    if(arrivalTime != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.arrivalTime(arrivalTime);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.arrivalTime(arrivalTime));
                        }
                    }
                    break;
                }
                default:
            }
        }

        return flightRepository.findAll(flightSpec);
    }

    private DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);
    private DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    private Date parseDate(String strDate) {
        Date result = null;
        try {
            result = df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Date parseTime(String strTime) {
        Date result = null;
        try {
            result = tf.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
