package pl.chris.spring.entity.listener;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import pl.chris.spring.entity.AuditedBusinessEntity;

@Slf4j
@Component
public class AuditEntityWithAuditTrailListener extends AuditingEntityListener {

    private static final String DUMMY_USER = "ADMIN@WORLD.COM";

    @SuppressWarnings("java:S125")
    @PreRemove
    public void beforeChangeHappenedRemove(final AuditedBusinessEntity oldObject) {
        log.debug(
                String.format("Audit on delete was skipped for entity with uuid: %s", oldObject.getUuid()));
    }

    // wrongly recommends to change the type in the signature
    @SuppressWarnings({"java:S3242", "java:S125"})
    @PreUpdate
    public void beforeChangeHappenedUpdate(final AuditedBusinessEntity newObject) {
        log.debug(
                String.format("Audit on update was skipped entity with uuid: %s", newObject.getUuid()));
        prepareAuditDataForUpdate(newObject);
    }

    @SuppressWarnings("java:S125")
    @PrePersist
    public void beforeChangeHappenedInsert(final AuditedBusinessEntity toBeSaved) {
        log.debug(
                String.format("Audit on update entity was skipped with uuid: %s", toBeSaved.getUuid()));
        prepareAuditDataForCreate(toBeSaved);
    }

    private void prepareAuditDataForCreate(AuditedBusinessEntity businessEntity) {
        var now = LocalDateTime.now(ZoneOffset.UTC);
        businessEntity.setCreatedDate(now);
        businessEntity.setUpdatedDate(now);
        businessEntity.setUpdatedBy(DUMMY_USER);
        businessEntity.setCreatedBy(DUMMY_USER);
    }

    private void prepareAuditDataForUpdate(AuditedBusinessEntity businessEntity) {
        businessEntity.setUpdatedDate(LocalDateTime.now(ZoneOffset.UTC));
        businessEntity.setUpdatedBy(DUMMY_USER);
    }
}
