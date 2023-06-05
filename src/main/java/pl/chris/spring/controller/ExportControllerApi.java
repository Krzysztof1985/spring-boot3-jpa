package pl.chris.spring.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import pl.chris.spring.model.ExportDto;


@Tag(name = ExportControllerApi.TAG)
public interface ExportControllerApi {


    String TAG = "Export Service";

    @Operation(tags = TAG,
            summary = "Says hello")
    @GetMapping("/{domainUuid}")
    ResponseEntity<List<ExportDto>> findAllByDomainUuid(@PathVariable @NonNull String domainUuid, @SortDefault(sort = "updatedDate",
            direction = Sort.Direction.DESC) Pageable pageable);
}
