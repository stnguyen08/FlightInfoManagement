package cs544.flight.repository;

import com.sun.tools.corba.se.idl.InterfaceGen;
import cs544.flight.domain.Airline;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirlinePersistence implements IAirlinePersistence {

    private Map<Integer, Airline> airlines = new HashMap<>();
    private SessionFactory sf;

    public Map<Integer, Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(Map<Integer, Airline> airlines) {
        this.airlines = airlines;
    }

    public SessionFactory getSessionFactory() {
        return sf;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sf = sf;
    }

    public AirlinePersistence() {

    }

    @Override
    public List<Airline> getAll() {
        return new ArrayList<Airline>(airlines.values());
    }

    @Override
    public void add(Airline airline) {
        this.airlines.put(airline.getId(),airline);
    }

    @Override
    public Airline get(int id) {
        Airline airline = airlines.get(id);
        if (airline == null){
            //throw new NoSuchResourceException("Airline", id);
        }
        return airline;

    }

    @Override
    public void update(int id, Airline airline) {

        this.airlines.put(airline.getId(),airline);
    }


    @Override
    public void delete(int airlineId) {
        Airline airline = airlines.remove(airlineId);
        if (airline == null){
            //throw new NoSuchResourceException("Airline", id);
        }


    }
}
