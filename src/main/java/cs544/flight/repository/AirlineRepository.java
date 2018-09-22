package cs544.flight.repository;

import com.sun.tools.corba.se.idl.InterfaceGen;
import cs544.flight.domain.Airline;
import cs544.flight.domain.Flight;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("AirlineRepository")
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
