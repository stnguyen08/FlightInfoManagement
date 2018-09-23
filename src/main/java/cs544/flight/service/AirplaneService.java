package cs544.flight.service;

import cs544.flight.domain.Airplane;
import cs544.flight.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService implements IAirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public void save(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public Airplane get(int id) {

        return airplaneRepository.getOne(id);

    }

    @Override
    public void delete(int airplaneId) {
        airplaneRepository.delete(airplaneId);

    }
}
