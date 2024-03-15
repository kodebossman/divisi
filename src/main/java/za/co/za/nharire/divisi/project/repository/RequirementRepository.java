package za.co.za.nharire.divisi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.za.nharire.divisi.project.models.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}