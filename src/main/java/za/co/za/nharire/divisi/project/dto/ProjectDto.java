package za.co.za.nharire.divisi.project.dto;

import lombok.Data;
import za.co.za.nharire.divisi.enums.ProjectType;

import java.util.List;
@Data
public class ProjectDto {
    private Long id;
    private String name;
    private ProjectType projectType;
    private Integer estimatedDuration;
    private List<RequirementDto> requirements;
    private Long farmerId;
}
