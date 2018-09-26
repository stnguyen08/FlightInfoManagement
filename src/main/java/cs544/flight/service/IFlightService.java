package cs544.flight.service;

import cs544.flight.domain.Flight;

import java.util.List;

public interface IFlightService extends IBaseService<Flight> {

    List<Flight> search(String criteria);
}
