package za.co.za.nharire.divisi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.za.nharire.divisi.project.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}