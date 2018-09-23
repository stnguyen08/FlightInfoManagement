package cs544.flight.repository;

import cs544.flight.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AirlineRepository")
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
