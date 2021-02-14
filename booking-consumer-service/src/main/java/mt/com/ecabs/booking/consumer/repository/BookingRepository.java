package mt.com.ecabs.booking.consumer.repository;

import mt.com.ecabs.booking.consumer.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
