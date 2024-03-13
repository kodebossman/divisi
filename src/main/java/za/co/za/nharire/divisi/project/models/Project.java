package za.co.za.nharire.divisi.project.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import za.co.za.nharire.divisi.enums.ProjectType;
import za.co.za.nharire.divisi.farmer.model.Farmer;
import za.co.za.nharire.divisi.project.models.Requirement;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_type", nullable = false)
    private ProjectType projectType;

    @Column(name = "estimated_duration", nullable = false)
    private Integer estimatedDuration;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Requirement> requirements = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;


}

