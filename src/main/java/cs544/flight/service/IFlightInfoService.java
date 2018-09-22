package cs544.flight.service;

import java.util.List;

import cs544.flight.model.FlightInfo;

public interface IFlightInfoService {
	 List<FlightInfo> findAll();
	 FlightInfo save(FlightInfo carOwner);
	 FlightInfo findOne(Long id);
	 void delete(Long id);
}
