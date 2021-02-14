package mt.com.ecabs.booking.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbitmq.exchanges")
public class ExchangeProperties {
    private String messageExchange;
    private String bookingExchange;
}
