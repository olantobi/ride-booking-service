package mt.com.ecabs.booking.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbitmq.exchanges")
public class ExchangeProperties {
    private String messageExchange;
    private String bookingExchange;
}
