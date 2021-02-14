package mt.com.ecabs.booking.producer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public TopicExchange messageExchange() {
        return new TopicExchange(exchangeProperties.getMessageExchange());
    }

    @Bean
    public TopicExchange bookingExchange() {
        return new TopicExchange(exchangeProperties.getBookingExchange());
    }

    @Bean
    public Queue addBookingQueue() {
        return new Queue(queueProperties.getBookingAddQueue());
    }

    @Bean
    public Queue editBookingQueue() {
        return new Queue(queueProperties.getBookingEditQueue());
    }

    @Bean
    public Queue deleteBookingQueue() {
        return new Queue(queueProperties.getBookingDeleteQueue());
    }

    @Bean
    public Queue messageAuditQueue() {
        return new Queue(queueProperties.getMessageAuditQueue());
    }

    @Bean
    public Binding bookingExchangeBindng() {
        return BindingBuilder.bind(bookingExchange()).to(messageExchange()).with(routingKeyProperties.getBookingExchange());
    }

    @Bean
    public Binding addQueueBinding() {
        return BindingBuilder.bind(addBookingQueue()).to(bookingExchange()).with(routingKeyProperties.getAddBooking());
    }

    @Bean
    public Binding editQueueBinding() {
        return BindingBuilder.bind(editBookingQueue()).to(bookingExchange()).with(routingKeyProperties.getEditBooking());
    }

    @Bean
    public Binding deleteQueueBinding() {
        return BindingBuilder.bind(deleteBookingQueue()).to(bookingExchange()).with(routingKeyProperties.getDeleteBooking());
    }

    @Bean
    public Binding messageAuditBinding() {
        return BindingBuilder.bind(messageAuditQueue()).to(messageExchange()).with(routingKeyProperties.getMessageAudit());
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
}
