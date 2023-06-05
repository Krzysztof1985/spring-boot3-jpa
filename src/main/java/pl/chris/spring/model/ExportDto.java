package pl.chris.spring.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ExportDto {
    private UUID uuid;
    private boolean forced;
    private UUID currencyExUuid;
    private boolean useLatestDate;
    private LocalDateTime cutoffTime;
    private String status;
    private long dataDomainUid;
    private String domainUuid;
    private String updatedBy;
    protected String createdBy;
    protected LocalDateTime updatedDate;
    protected LocalDateTime createdDate;
}
