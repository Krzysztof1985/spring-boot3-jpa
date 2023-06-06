package pl.chris.spring.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;
import pl.chris.spring.entity.ExportEntity;

public interface ExportRepository extends JpaRepository<ExportEntity, UUID> {
    @Transactional(readOnly = true)
    Page<ExportEntity> findAllByDomainUuid(String domainUuid, Pageable pageable);
}
