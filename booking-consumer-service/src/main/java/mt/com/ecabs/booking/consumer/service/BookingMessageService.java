package mt.com.ecabs.booking.consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mt.com.ecabs.booking.consumer.model.Booking;
import mt.com.ecabs.booking.consumer.repository.BookingRepository;
import mt.com.ecabs.booking.consumer.utils.OrikaUtils;
import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.MessageWrapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingMessageService implements MessageService {

    private final BookingRepository bookingRepository;

    @Override
    public void addBooking(MessageWrapper<BookingDto> bookingMessage) {
        Booking booking = OrikaUtils.map(bookingMessage.getMessage(), Booking.class);
        bookingRepository.save(booking);
    }

    @Override
    public void editBooking(MessageWrapper<BookingDto> bookingMessage) {
        BookingDto bookingDto = bookingMessage.getMessage();
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingDto.getId());
        if (bookingOptional.isPresent()) {
            Booking booking = OrikaUtils.map(bookingDto, Booking.class);
            bookingRepository.save(booking);

            return;
        }

        log.error("Invalid booking record. "+ bookingDto);
    }

    @Override
    public void deleteBooking(MessageWrapper<BookingDto> bookingMessage) {
        BookingDto bookingDto = bookingMessage.getMessage();
        bookingRepository.deleteById(bookingDto.getId());
    }
}
