package cs544.flight.service.impl;

import cs544.flight.domain.Airport;
import cs544.flight.repository.AirportRepository;
import cs544.flight.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AirportService")
public class AirportService implements IAirportService {
    @Autowired
    AirportRepository airportRepository;


    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport save(Airport airplane) {
        return airportRepository.save(airplane);
    }

    @Override
    public Airport findOne(Integer id) {
        return airportRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        airportRepository.delete(id);
    }
}
