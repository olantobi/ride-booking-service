package mt.com.ecabs.booking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {
    public Long id;
    private String passengerName;
    private String passengerContactNumber;
    private LocalDateTime pickupTime;
    private boolean asap;
    private int waitingTime;
    private int numberOfPassengers;
    private double price;
    private int rating;
}
