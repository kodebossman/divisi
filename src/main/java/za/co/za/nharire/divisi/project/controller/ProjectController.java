package za.co.za.nharire.divisi.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.za.nharire.divisi.project.dto.ProjectDto;
import za.co.za.nharire.divisi.project.dto.RequirementDto;
import za.co.za.nharire.divisi.project.service.ProjectService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/create-project")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        ProjectDto createdProject = projectService.createProject(projectDto);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/get-project-by-id/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id) {
        ProjectDto project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/all-projects")
    public ResponseEntity<List<RequirementDto>> getAllProjects() {
        List<RequirementDto> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/update-project/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        projectDto.setId(id);
        ProjectDto updatedProject = projectService.updateProject(projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/remove-project/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{projectId}/cost")
    public ResponseEntity<BigDecimal> calculateTotalCost(@PathVariable Long projectId, @RequestBody Integer quantity) {
        BigDecimal totalCost = projectService.calculateTotalCost(projectId, quantity);
        return ResponseEntity.ok(totalCost);
    }
}
