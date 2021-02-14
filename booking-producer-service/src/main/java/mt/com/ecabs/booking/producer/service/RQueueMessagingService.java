package mt.com.ecabs.booking.producer.service;

import lombok.RequiredArgsConstructor;
import mt.com.ecabs.booking.dto.BookingDto;
import mt.com.ecabs.booking.dto.MessageWrapper;
import mt.com.ecabs.booking.producer.config.ExchangeProperties;
import mt.com.ecabs.booking.producer.config.RoutingKeyProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RQueueMessagingService implements MessagingService {

    private final AmqpTemplate rabbitTemplate;
    private final ExchangeProperties exchangeProperties;
    private final RoutingKeyProperties routingKeyProperties;

    @Override
    public void sendMessage(MessageWrapper<BookingDto> message) {
        String routingKey = message.getOperation().name().toLowerCase() + "." + routingKeyProperties.getSuffix();

        rabbitTemplate.convertAndSend(exchangeProperties.getMessageExchange(), routingKey, message);
    }
}
