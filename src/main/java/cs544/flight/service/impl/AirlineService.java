package cs544.flight.service.impl;

import cs544.flight.domain.Airline;
import cs544.flight.repository.AirlineRepository;
import cs544.flight.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AirlineService")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AirlineService implements IAirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override

    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline findOne(Integer id) {
        return airlineRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        airlineRepository.delete(id);
    }
}
