package za.co.za.nharire.divisi.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.za.nharire.divisi.location.Village;
@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
}
