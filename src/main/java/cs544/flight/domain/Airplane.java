package cs544.flight.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airplane {
	@Id
	@GeneratedValue
	private int id;
	private String serialNumber;
	private String model;
	private int capacity;
	@OneToMany(mappedBy="airplane")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airplane() {
	}

	public Airplane(String serialnr, String model, int capacity) {
		this.serialNumber = serialnr;
		this.model = model;
		this.capacity = capacity;
	}

	/* Getters and Setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialnr() {
		return serialNumber;
	}

	public void setSerialnr(String serialnr) {
		this.serialNumber = serialnr;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/* Collection Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) { 
			flight.setAirplane(this);
			success = true;
		}
		return success;
	}
	
	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirplane(null);
			success = true;
		}
		return success;
	}
}
