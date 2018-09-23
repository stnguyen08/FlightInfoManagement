package cs544.flight.repository;

import cs544.flight.domain.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AirplaneRepository")
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {


}
