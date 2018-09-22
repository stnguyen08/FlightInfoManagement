package cs544.flight.model;

import java.time.LocalDate;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Flight")
public class FlightInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long flightId;

    public FlightInfo() {
    }
}
