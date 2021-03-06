package cs544.flight.repository;

import cs544.flight.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import org.springframework.data.mongodb.repository.MongoRepository;


@Repository("FlightRepository")
@Transactional(propagation = Propagation.REQUIRED)
//public interface FlightRepository extends MongoRepository<Flight, Long> {
public interface FlightRepository extends JpaRepository<Flight, Integer>, JpaSpecificationExecutor<Flight> {

}
