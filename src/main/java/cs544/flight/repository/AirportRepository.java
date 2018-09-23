package cs544.flight.repository;

import cs544.flight.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AirportRepository")
public interface AirportRepository extends JpaRepository<Airport, Integer> {


}
