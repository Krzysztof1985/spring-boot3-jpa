package pl.chris.spring.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.chris.spring.model.ExportDto;
import pl.chris.spring.service.ExportService;

@RestController
@RequestMapping("/export")
@RequiredArgsConstructor
public class ExportController implements ExportControllerApi {
    private final ExportService exportService;

    public ResponseEntity<List<ExportDto>> findAllByDomainUuid(@PathVariable @NonNull String domainUuid, @SortDefault(sort = "updatedDate",
            direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(exportService.findAllByDomainUuid(domainUuid, pageable));
    }
}
