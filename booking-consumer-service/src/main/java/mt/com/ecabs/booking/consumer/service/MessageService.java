package mt.com.ecabs.booking.consumer.service;

import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.MessageWrapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface MessageService {

    @RabbitListener(queues = "${rabbitmq.queues.booking-add-queue}", containerFactory = "bookingFactory")
    void addBooking(MessageWrapper<BookingDto> bookingMessage);

    @RabbitListener(queues = "${rabbitmq.queues.booking-edit-queue}", containerFactory = "bookingFactory")
    void editBooking(MessageWrapper<BookingDto> bookingMessage);

    @RabbitListener(queues = "${rabbitmq.queues.booking-delete-queue}", containerFactory = "bookingFactory")
    void deleteBooking(MessageWrapper<BookingDto> bookingMessage);
}
