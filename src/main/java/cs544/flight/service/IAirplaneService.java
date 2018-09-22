package cs544.flight.service;

import cs544.flight.domain.Airplane;

import java.util.ArrayList;
import java.util.List;

public interface IAirplaneService {

    public List<Airplane> getAll() ;

    public Airplane get(int id) ;

    public void save(Airplane airplane);

    public void delete(int airplaneId);
}
