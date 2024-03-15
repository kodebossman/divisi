package za.co.za.nharire.divisi.project.service;

import za.co.za.nharire.divisi.project.dto.ProjectDto;
import za.co.za.nharire.divisi.project.dto.RequirementDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);
    ProjectDto getProjectById(Long id);
    List<RequirementDto> getAllProjects();
    ProjectDto updateProject(ProjectDto projectDto);
    void deleteProject(Long id);
    BigDecimal calculateTotalCost(Long projectId, Integer quantity);
}
