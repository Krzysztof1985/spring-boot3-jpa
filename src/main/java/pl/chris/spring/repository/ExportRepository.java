package pl.chris.spring.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.chris.spring.entity.ExportEntity;

public interface ExportRepository extends JpaRepository<ExportEntity, UUID> {

    Page<ExportEntity> findAllByDomainUuid(String domainUuid, Pageable pageable);
}
