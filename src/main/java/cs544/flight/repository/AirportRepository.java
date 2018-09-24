package cs544.flight.repository;

import cs544.flight.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("AirportRepository")
@Transactional(propagation = Propagation.REQUIRED)
public interface AirportRepository extends JpaRepository<Airport, Integer> {


}
