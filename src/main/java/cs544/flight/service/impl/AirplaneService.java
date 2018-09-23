package cs544.flight.service.impl;

import cs544.flight.domain.Airplane;
import cs544.flight.repository.AirplaneReposistory;
import cs544.flight.service.IAirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AirplaneService")
public class AirplaneService implements IAirplaneService {
    @Autowired
    AirplaneReposistory airplaneReposistory;


    @Override
    public List<Airplane> findAll() {
        return airplaneReposistory.findAll();
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneReposistory.save(airplane);
    }

    @Override
    public Airplane findOne(Long id) {
        return airplaneReposistory.findOne(id);
    }

    @Override
    public void delete(Long id) {
        airplaneReposistory.delete(id);
    }
}
