package za.co.za.nharire.divisi.project.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import za.co.za.nharire.divisi.farmer.model.Farmer;
import za.co.za.nharire.divisi.project.dto.ProjectDto;
import za.co.za.nharire.divisi.project.dto.RequirementDto;
import za.co.za.nharire.divisi.project.models.Project;
import za.co.za.nharire.divisi.project.models.Requirement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto toDto(Project project);
    Project toEntity(ProjectDto projectDto);

    @Mapping(source = "farmer.id", target = "farmerId")
    ProjectDto toDtoWithFarmerId(Project project);

    @Mapping(source = "farmerId", target = "farmer")
    Project toEntityWithFarmer(ProjectDto projectDto, @Context Farmer farmer);

    List<RequirementDto> toDtoList(List<Requirement> requirements);
    List<Requirement> toEntityList(List<RequirementDto> requirementDtos);
}
