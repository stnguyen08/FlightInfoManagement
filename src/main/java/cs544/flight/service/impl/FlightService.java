package cs544.flight.service.impl;

import java.util.List;

import cs544.flight.domain.Flight;
import cs544.flight.repository.FlightRepository;
import cs544.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

}
