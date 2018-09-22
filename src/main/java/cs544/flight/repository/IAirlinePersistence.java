package cs544.flight.repository;

import cs544.flight.domain.Airline;

import java.util.List;

public interface IAirlinePersistence {
   public List<Airline> getAll();

    public void  add(Airline airline);

    public Airline get(int id);

    public void update(int id, Airline airline);

    public void delete(int airlineId);
}
