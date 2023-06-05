package pl.chris.spring.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.chris.spring.entity.listener.AuditEntityWithAuditTrailListener;

@Getter
@Setter
@NoArgsConstructor
@EntityListeners({AuditEntityWithAuditTrailListener.class})
@MappedSuperclass
public class AuditedBusinessEntity extends BusinessEntitiesData {
    @LastModifiedBy
    protected String updatedBy;

    @CreatedBy
    protected String createdBy;

    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @CreatedDate
    protected LocalDateTime createdDate;

    @Column(name = "version")
    @Version
    protected long version;

    public AuditedBusinessEntity(UUID uuid, String domainUuid) {
        super(uuid, domainUuid);
    }

    public AuditedBusinessEntity(UUID uuid, String domainUuid, LocalDateTime updatedDate) {
        super(uuid, domainUuid);
        this.updatedDate = updatedDate;
    }

    public AuditedBusinessEntity(
            UUID uuid,
            String domainUuid,
            String updatedBy,
            LocalDateTime updatedDate,
            String createdBy,
            LocalDateTime createdDate,
            long version) {
        super(uuid, domainUuid);
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.version = version;
    }

    public AuditedBusinessEntity(String domainUuid) {
        super(null, domainUuid);
    }
}
