package mt.com.ecabs.booking.producer.service;

import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.MessageWrapper;

public interface MessagingService {
    void sendMessage(MessageWrapper<BookingDto> messageWrapper);
}
