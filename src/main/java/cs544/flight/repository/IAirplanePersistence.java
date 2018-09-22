package cs544.flight.repository;


import cs544.flight.domain.Airplane;


import java.util.List;

public interface IAirplanePersistence {

    public List<Airplane> getAll();

    public void add(Airplane airplane);

    public Airplane get(int id) ;

    public void update(int id, Airplane airplane);

    public void delete(int airplaneId) ;


}
