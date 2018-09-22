package cs544.flight.service;

import cs544.flight.domain.Airline;
import cs544.flight.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements IAirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline save(Airline airline) {

        return airlineRepository.save(airline);
    }

    @Override
    public Airline get(int id) {
        return airlineRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        this.airlineRepository.delete(id);
    }

}
