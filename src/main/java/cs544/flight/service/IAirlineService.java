package cs544.flight.service;

import cs544.flight.domain.Airline;
import cs544.flight.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IAirlineService {


    public List<Airline> getAll();

    public Airline save(Airline airline);

    public Airline get(int id);

    public void delete(int id);
}
