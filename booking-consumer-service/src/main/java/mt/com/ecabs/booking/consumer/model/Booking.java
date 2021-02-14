package mt.com.ecabs.booking.consumer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking extends TimestampedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long id;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "passenger_contact_number")
    private String passengerContactNumber;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    private boolean asap;

    @Column(name = "waiting_time")
    private int waitingTime;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    private double price;

    private int rating;

    @OneToMany(mappedBy="booking", cascade = CascadeType.ALL)
    private List<TripWayPoint> tripWayPoints;
}
