package cs544.flight.repository;

import cs544.flight.domain.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AirplaneReposistory")
public interface AirplaneReposistory extends JpaRepository<Airplane, Long> {
}
