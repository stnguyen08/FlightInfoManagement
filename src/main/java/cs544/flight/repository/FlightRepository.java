package cs544.flight.repository;

import cs544.flight.model.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;


@Repository("FlightRepository")
//public interface FlightRepository extends MongoRepository<FlightInfo, Long> {
public interface FlightRepository extends JpaRepository<FlightInfo, Long> {
}
