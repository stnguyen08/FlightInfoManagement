package cs544.flight.repository;

import cs544.flight.domain.Airline;
import cs544.flight.domain.Airplane;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("AirplaneRepository")
public interface AirplaneRepository extends JpaRepository<Airplane,Integer> {


}
