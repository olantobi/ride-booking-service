package mt.com.ecabs.booking.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MessageWrapper<T> implements Serializable {
    private T message;
    private Operation operation;
}
