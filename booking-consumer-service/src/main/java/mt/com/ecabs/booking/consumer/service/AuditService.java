package mt.com.ecabs.booking.consumer.service;

import mt.com.ecabs.booking.dto.MessageWrapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface AuditService<T> {

    @RabbitListener(queues = "${rabbitmq.queues.message-audit-queue}", containerFactory = "bookingFactory")
    void auditConsumer(MessageWrapper<T> message);
}
