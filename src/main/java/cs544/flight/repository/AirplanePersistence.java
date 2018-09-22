package cs544.flight.repository;

import cs544.flight.domain.Airline;
import cs544.flight.domain.Airplane;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirplanePersistence implements IAirplanePersistence {

    private Map<Integer, Airplane> airplanes = new HashMap<>();
    private SessionFactory sf;

    public Map<Integer, Airplane> getAirlines() {
        return airplanes;
    }

    public void setAirlines(Map<Integer, Airplane> airlines) {
        this.airplanes = airlines;
    }

    public SessionFactory getSessionFactory() {
        return sf;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sf = sf;
    }

    public AirplanePersistence() {

    }

    @Override
    public List<Airplane> getAll() {
        return new ArrayList<Airplane>(airplanes.values());
    }

    @Override
    public void add(Airplane airplane) {
        this.airplanes.put(airplane.getId(),airplane);
    }

    @Override
    public Airplane get(int id) {
        Airplane airplane = airplanes.get(id);
        if (airplane == null){
            //throw new NoSuchResourceException("Airline", id);
        }
        return airplane;

    }

    @Override
    public void update(int id, Airplane airplane) {

        this.airplanes.put(airplane.getId(),airplane);
    }


    @Override
    public void delete(int airplaneId) {
        Airplane airplane = airplanes.remove(airplaneId);
        if (airplane == null){
            //throw new NoSuchResourceException("Airline", id);
        }


    }
}
