package za.co.za.nharire.divisi.farmer.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.za.nharire.divisi.farmer.model.Farmer;
@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
