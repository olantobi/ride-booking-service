package mt.com.ecabs.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity {
    @Id
    public Long id;
    private String passengerName;
    private String passengerContactNumber;
    private LocalDateTime pickupTime;
    private boolean asap;
    private int waitingTime;
    private int numberOfPassengers;
    private double price;
    private int rating;

    private List<TripWayPoint> tripWayPoints;
}
