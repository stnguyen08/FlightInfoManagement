package cs544.flight.repository;

import cs544.flight.domain.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("AirplaneRepository")
@Transactional(propagation = Propagation.REQUIRED)
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {


}
