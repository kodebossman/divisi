package za.co.za.nharire.divisi.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.za.nharire.divisi.project.dto.ProjectDto;
import za.co.za.nharire.divisi.project.dto.RequirementDto;
import za.co.za.nharire.divisi.project.mapper.ProjectMapper;
import za.co.za.nharire.divisi.project.models.Project;
import za.co.za.nharire.divisi.project.repository.ProjectRepository;
import za.co.za.nharire.divisi.project.repository.RequirementRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RequirementRepository requirementRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }


    @Override
    public ProjectDto getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return projectMapper.toDto(project);
    }

    @Override
    public List<RequirementDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.toDtoList(projects);
    }


    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        Project updatedProject = projectRepository.save(project);
        return projectMapper.toDto(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public BigDecimal calculateTotalCost(Long projectId, Integer quantity) {
        // Placeholder for cost calculation logic
        return new BigDecimal(quantity).multiply(new BigDecimal(10)); // Example cost per unit
    }
}
