package mt.com.ecabs.booking.consumer.model;

import lombok.Data;

import javax.persistence.*;

@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Booking booking;
}
