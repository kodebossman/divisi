package za.co.za.nharire.divisi.project.dto;

import lombok.Data;
import za.co.za.nharire.divisi.enums.UnitOfMeasure;
@Data
public class RequirementDto {
    private Long id;
    private String description;
    private Integer quantity;
    private UnitOfMeasure unitOfMeasure;
}
