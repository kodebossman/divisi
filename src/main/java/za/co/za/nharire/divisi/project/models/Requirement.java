package za.co.za.nharire.divisi.project.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import za.co.za.nharire.divisi.enums.UnitOfMeasure;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "requirements")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private UnitOfMeasure unitOfMeasure;



    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


}
