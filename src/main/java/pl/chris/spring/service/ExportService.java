package pl.chris.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.chris.spring.mapper.ExportMapper;
import pl.chris.spring.model.ExportDto;
import pl.chris.spring.repository.ExportRepository;

@Service
@RequiredArgsConstructor
public class ExportService {
    private static final ExportMapper EXPORT_MAPPER = ExportMapper.INSTANCE;
    private final ExportRepository exportRepository;


    public List<ExportDto> findAllByDomainUuid(String domainUuid, Pageable pageable) {
        return exportRepository.findAllByDomainUuid(domainUuid, pageable)
                .getContent()
                .stream()
                .map(EXPORT_MAPPER::mapToDto)
                .collect(Collectors.toList());

    }
}