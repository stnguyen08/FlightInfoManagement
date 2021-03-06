package cs544.flight.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "should not be empty")
    private String flightnr;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;
    //	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate departureDate;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date departureTime;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date arrivalTime;
    //	@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    private Airline airline;
    //	@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    private Airport origin;
    //	@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    private Airport destination;
    //	@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    private Airplane airplane;

    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);
    private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    /* Constructors */
    public Flight() {
    }

    public Flight(String flightnr, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime) {
        this.flightnr = flightnr;
        //setDepartureDate(departureDate);
        //setDepartureTime(departureTime);
        //setArrivalDate(arrivalDate);
        //setArrivalTime(arrivalTime);
    }

    public Flight(String flightnr, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime, Airline airline,
                  Airport origin, Airport destination, Airplane airplane) {
        this.flightnr = flightnr;
        //setDepartureDate(departureDate);
        //setDepartureTime(departureTime);
        //setArrivalDate(arrivalDate);
        //setArrivalTime(arrivalTime);
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.airplane = airplane;
    }

    /* Getters & Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightnr() {
        return flightnr;
    }

    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }

	/*public String getDepartureDate() {
		return df.format(departureDate);
	}

	public void setDepartureDate(String departureDate) {
		try {
			this.departureDate = df.parse(departureDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

	/*public String getDepartureTime() {
		return tf.format(departureTime);
	}

	public void setDepartureTime(String departureTime) {
		try {
			this.departureTime = tf.parse(departureTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

	/*public String getArrivalDate() {
		return df.format(arrivalDate);
	}

	public void setArrivalDate(String arrivalDate) {
		try {
			this.arrivalDate = df.parse(arrivalDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

	/*public String getArrivalTime() {
		return tf.format(arrivalTime);
	}

	public void setArrivalTime(String arrivalTime) {
		try {
			this.arrivalTime = tf.parse(arrivalTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightnr='" + flightnr + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
