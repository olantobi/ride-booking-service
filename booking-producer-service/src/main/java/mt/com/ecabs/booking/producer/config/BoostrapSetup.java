package mt.com.ecabs.booking.producer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class BoostrapSetup implements CommandLineRunner {
    private final AmqpAdmin amqpAdmin;
    private final RabbitMqConfig rabbitMqConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating exchanges, queues and bindings");

        amqpAdmin.declareExchange(rabbitMqConfig.messageExchange());
        amqpAdmin.declareExchange(rabbitMqConfig.bookingExchange());

        amqpAdmin.declareQueue(rabbitMqConfig.addBookingQueue());
        amqpAdmin.declareQueue(rabbitMqConfig.editBookingQueue());
        amqpAdmin.declareQueue(rabbitMqConfig.deleteBookingQueue());
        amqpAdmin.declareQueue(rabbitMqConfig.messageAuditQueue());

        amqpAdmin.declareBinding(rabbitMqConfig.bookingExchangeBindng());
        amqpAdmin.declareBinding(rabbitMqConfig.addQueueBinding());
        amqpAdmin.declareBinding(rabbitMqConfig.editQueueBinding());
        amqpAdmin.declareBinding(rabbitMqConfig.deleteQueueBinding());
        amqpAdmin.declareBinding(rabbitMqConfig.messageAuditBinding());
    }
}
