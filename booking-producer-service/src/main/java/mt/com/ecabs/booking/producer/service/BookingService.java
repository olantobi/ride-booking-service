package mt.com.ecabs.booking.producer.service;

import mt.com.ecabs.booking.dto.BookingDto;

import java.util.List;

public interface BookingService {
    void createBooking(BookingDto booking);
    void editBooking(BookingDto booking);
    void deleteBooking(long bookingId);
    BookingDto getBooking(long bookingId);
    List<BookingDto> getAllBookings();
}
