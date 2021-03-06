package cs544.flight.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airline {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "should not be empty")
	private String name;
	@OneToMany(mappedBy = "airline")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airline() {
	}

	public Airline(String name) {
		this.name = name;
	}

	/* Getters & Setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/* Collections Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) {
			flight.setAirline(this);
			success = true;
		}
		return success;
	}

	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirline(null);
			success = true;
		}
		return success;
	}
}
