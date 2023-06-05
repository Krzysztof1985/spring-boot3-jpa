package pl.chris.spring.startup;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.chris.spring.entity.ExportEntity;
import pl.chris.spring.repository.ExportRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDataStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final ExportRepository exportRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("Application started {}", event.getTimeTaken());
        var exportEntity = ExportEntity.builder()
                .forced(true)
                .dataDomainUid(1L)
                .domainUuid("11111111-1111-1111-1111-111111111111")
                .currencyExUuid(UUID.randomUUID())
                .useLatestDate(true)
                .status("STARTED")
                .cutoffTime(LocalDateTime.now())
                .build();

        exportRepository.save(exportEntity);

    }
}
