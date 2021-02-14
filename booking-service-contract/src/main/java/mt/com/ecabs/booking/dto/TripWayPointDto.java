package mt.com.ecabs.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripWayPointDto implements Serializable {
    private long id;
    private String locality;
    private double latitude;
    private double longitude;
}
