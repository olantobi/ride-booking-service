package mt.com.ecabs.booking.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbitmq.routing-keys")
public class RoutingKeyProperties {
    private String suffix;
    private String addBooking;
    private String editBooking;
    private String deleteBooking;
    private String messageAudit;
    private String bookingExchange;
}
