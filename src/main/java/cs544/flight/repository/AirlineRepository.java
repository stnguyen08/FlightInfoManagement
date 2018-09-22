package cs544.flight.repository;

import cs544.flight.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
