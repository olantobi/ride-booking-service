package mt.com.ecabs.booking.consumer.service;

import lombok.extern.slf4j.Slf4j;
import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.MessageWrapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintAuditService implements AuditService<BookingDto> {

    @Override
    public void auditConsumer(MessageWrapper<BookingDto> bookingMessage) {
        log.info(bookingMessage.toString());
    }
}
