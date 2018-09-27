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
        String[] str = criteria.split(";");

        Specification<Flight> flightSpec = null;

        for (String c : str) {
            System.out.println(c);
            String code = c.substring(0, 2);
            String opt = c.substring(2, 3);
            String value = c.substring(3);
            System.out.println(code + " " + opt + " " + value);
            switch (code) {
                case "FN": {
                    if(!value.isEmpty()) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.flightNr(value);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.flightNr(value));
                        }
                    }
                    break;
                }
                case "DD": {
                    if(value != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.departureDate(parseDate(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.departureDate(parseDate(value)));
                        }
                    }
                    break;
                }
                case "DT": {
                    if(value != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.departureTime(parseTime(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.departureTime(parseTime(value)));
                        }
                    }
                    break;
                }
                case "AD": {
                    if(value != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.arrivalDate(parseDate(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.arrivalDate(parseDate(value)));
                        }
                    }
                    break;
                }
                case "AT": {
                    if(value != null) {
                        if(flightSpec == null) {
                            flightSpec = FlightSpecification.arrivalTime(parseTime(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.arrivalTime(parseTime(value)));
                        }
                    }
                    break;
                }
                default:
            }
        }

        return flightRepository.findAll(flightSpec);
    }

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
    private DateFormat tf = new SimpleDateFormat("HH:mm"); //DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);



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
