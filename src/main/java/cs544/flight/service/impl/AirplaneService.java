package cs544.flight.service.impl;

import cs544.flight.domain.Airplane;
import cs544.flight.repository.AirplaneRepository;
import cs544.flight.service.IAirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AirplaneService")
public class AirplaneService implements IAirplaneService {
    @Autowired
    AirplaneRepository airplaneRepository;


    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane findOne(Integer id) {
        return airplaneRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        airplaneRepository.delete(id);
    }
}
