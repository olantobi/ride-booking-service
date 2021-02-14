package mt.com.ecabs.booking.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbitmq.queues")
public class QueueProperties {
    private String messageAuditQueue;
    private String bookingAddQueue;
    private String bookingEditQueue;
    private String bookingDeleteQueue;
}
