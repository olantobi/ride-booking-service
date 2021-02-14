package mt.com.ecabs.booking.consumer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "trip_way_points")
public class TripWayPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String locality;

    private double latitude;

    private double longitude;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
