package mt.com.ecabs.booking.producer.service;

import mt.com.ecabs.booking.dto.BookingDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MQBookingService implements BookingService {

    @Override
    public void createBooking(BookingDto booking) {

    }

    @Override
    public void editBooking(BookingDto booking) {

    }

    @Override
    public void deleteBooking(long bookingId) {

    }

    @Override
    public BookingDto getBooking(long bookingId) {
        return null;
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return null;
    }
}
