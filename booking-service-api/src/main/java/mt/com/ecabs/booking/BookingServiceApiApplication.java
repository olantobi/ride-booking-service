package mt.com.ecabs.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookingServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApiApplication.class, args);
    }

}
