package mt.com.ecabs.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto implements Serializable {
    public long id;
    private String passengerName;
    private String passengerContactNumber;

    private String pickupTime;

    private boolean asap;
    private int waitingTime;
    private int numberOfPassengers;
    private double price;
    private int rating;

    List<TripWayPointDto> tripWayPoints;
}
