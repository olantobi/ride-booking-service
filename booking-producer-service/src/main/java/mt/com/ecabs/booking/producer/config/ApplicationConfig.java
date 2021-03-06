package mt.com.ecabs.booking.producer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({ExchangeProperties.class, QueueProperties.class, RoutingKeyProperties.class})
@Configuration
public class ApplicationConfig {
}
