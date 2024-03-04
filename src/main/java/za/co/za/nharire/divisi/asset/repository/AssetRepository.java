package za.co.za.nharire.divisi.asset.repository;


import org.springframework.data.repository.CrudRepository;
import za.co.za.nharire.divisi.asset.model.Asset;

public interface AssetRepository<T extends Asset> extends CrudRepository<T, Long> {

}
