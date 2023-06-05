package pl.chris.spring.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import pl.chris.spring.entity.ExportEntity;
import pl.chris.spring.model.ExportDto;

@Mapper()
public interface ExportMapper {

    ExportMapper INSTANCE = Mappers.getMapper(ExportMapper.class);

    ExportDto mapToDto(ExportEntity entity);

    List<ExportDto> mapCollection(Collection<ExportDto> input);
}
