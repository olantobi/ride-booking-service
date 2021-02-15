package mt.com.ecabs.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto implements Serializable {
    public long id;

    @NotBlank(message = "Passenger name is required")
    private String passengerName;

    @NotBlank(message = "Passenger contact number is required")
    @Pattern(message = "Invalid contact number", regexp="^(\\+)?[0-9]*$")
    private String passengerContactNumber;

    @NotBlank(message = "Pickup time is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "Invalid date time format. Expected format is yyyy-MM-dd HH:mm:ss")
    private String pickupTime;

    private boolean asap;
    private int waitingTime;
    private int numberOfPassengers;
    private double price;
    private int rating;

    List<TripWayPointDto> tripWayPoints;
}
