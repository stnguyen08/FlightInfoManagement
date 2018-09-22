package cs544.flight.service;

import java.util.List;

import cs544.flight.domain.Flight;

public interface IFlightService {
	 List<Flight> findAll();
	 Flight save(Flight flight);
	 Flight findOne(Long id);
	 void delete(Long id);
}
