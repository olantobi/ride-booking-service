package mt.com.ecabs.booking.producer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class RabbitMqConfig {
    private final ExchangeProperties exchangeProperties;
    private final QueueProperties queueProperties;
    private final RoutingKeyProperties routingKeyProperties;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    public TopicExchange messageExchange() {
        return new TopicExchange(exchangeProperties.getMessageExchange(), true, false);
    }

    public TopicExchange bookingExchange() {
        return new TopicExchange(exchangeProperties.getBookingExchange(), true, false);
    }

    public Queue addBookingQueue() {
        return new Queue(queueProperties.getBookingAddQueue(), true);
    }

    public Queue editBookingQueue() {
        return new Queue(queueProperties.getBookingEditQueue(), true);
    }

    public Queue deleteBookingQueue() {
        return new Queue(queueProperties.getBookingDeleteQueue(), true);
    }

    public Queue messageAuditQueue() {
        return new Queue(queueProperties.getMessageAuditQueue(), true);
    }

    public Binding bookingExchangeBindng() {
        return BindingBuilder.bind(bookingExchange()).to(messageExchange()).with(routingKeyProperties.getBookingExchange());
    }

    public Binding addQueueBinding() {
        return BindingBuilder.bind(addBookingQueue()).to(bookingExchange()).with(routingKeyProperties.getAddBooking());
    }

    public Binding editQueueBinding() {
        return BindingBuilder.bind(editBookingQueue()).to(bookingExchange()).with(routingKeyProperties.getEditBooking());
    }

    public Binding deleteQueueBinding() {
        return BindingBuilder.bind(deleteBookingQueue()).to(bookingExchange()).with(routingKeyProperties.getDeleteBooking());
    }

    public Binding messageAuditBinding() {
        return BindingBuilder.bind(messageAuditQueue()).to(messageExchange()).with(routingKeyProperties.getMessageAudit());
    }
}
