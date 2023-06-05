package pl.chris.spring.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "export")
public class ExportEntity extends AuditedBusinessEntity {
    @Column(name = "is_force")
    private boolean forced;

    @Column(name = "currency_ex_uuid")
    private UUID currencyExUuid;

    @Column(name = "is_use_latest_date")
    private boolean useLatestDate;

    private LocalDateTime cutoffTime;

    private String status;

    private long dataDomainUid;

    @Builder
    public ExportEntity(
            UUID uuid,
            String domainUuid,
            boolean forced,
            UUID currencyExUuid,
            boolean useLatestDate,
            LocalDateTime cutoffTime,
            String status,
            long dataDomainUid) {
        super(uuid, domainUuid);
        this.forced = forced;
        this.currencyExUuid = currencyExUuid;
        this.useLatestDate = useLatestDate;
        this.cutoffTime = cutoffTime;
        this.status = status;
        this.dataDomainUid = dataDomainUid;
    }
}
