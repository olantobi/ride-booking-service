package mt.com.ecabs.booking.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_on", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "last_modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;
}
