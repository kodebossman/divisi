package za.co.za.nharire.divisi.asset.service;



import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import za.co.za.nharire.divisi.asset.model.Asset;

import za.co.za.nharire.divisi.asset.repository.AssetRepository;
import za.co.za.nharire.divisi.farmer.repos.FarmerRepository;


import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class GenericAssetServiceImpl<T extends Asset> implements AssetService<T> {

    private final AssetRepository<T> assetRepository;
    private final FarmerRepository farmerRepository;

    @Override
    public T create(T asset, Long farmerId) {
        log.info("In Service ...");

        asset.setFarmerId(farmerId);

        log.info(" Created Asset {} ", asset);

        try {
            asset = assetRepository.save(asset);
        } catch (Exception exception) {
            log.error(" FAILED TO SAVE ASSET IN DB {}", exception.getMessage());
        }

        return asset;
    }

    @Override
    public T findById(Long id) {
        Optional<T> assetOptional = assetRepository.findById(id);
        return assetOptional.orElse(null);
    }

    @Override
    public Iterable<T> findAll() {
        return assetRepository.findAll();
    }

    @Override
    public T update(T asset) {
        return assetRepository.save(asset);
    }

    @Override
    public void delete(Long id) {
        assetRepository.deleteById(id);
    }
}

