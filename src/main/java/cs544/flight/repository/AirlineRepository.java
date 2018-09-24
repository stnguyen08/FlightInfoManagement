package cs544.flight.repository;

import cs544.flight.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("AirlineRepository")
@Transactional(propagation = Propagation.REQUIRED)
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
