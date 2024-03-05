package za.co.za.nharire.divisi.asset.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.za.nharire.divisi.asset.model.Asset;
import za.co.za.nharire.divisi.asset.service.GenericAssetServiceImpl;
import za.co.za.nharire.divisi.enums.AssetType;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class GenericAssetController {

    private final AssetServiceFactory assetServiceFactory;

    @Autowired
    public GenericAssetController(AssetServiceFactory assetServiceFactory) {
        this.assetServiceFactory = assetServiceFactory;
    }

    @PostMapping("/{assetType}")
    public <T extends Asset> T createAsset(@PathVariable AssetType assetType, @RequestBody T asset, @RequestParam Long farmerId) {
        GenericAssetServiceImpl<T> service = assetServiceFactory.getService(assetType);
        return service.create(asset, farmerId);
    }

    @GetMapping("/{assetType}/{id}")
    public Asset getAssetById(@PathVariable AssetType assetType, @PathVariable Long id) {
        GenericAssetServiceImpl<? extends Asset> service = assetServiceFactory.getService(assetType);
        return service.findById(id);
    }

    @GetMapping("/{assetType}")
    public List<Asset> getAllAssets(@PathVariable AssetType assetType) {
        GenericAssetServiceImpl<? extends Asset> service = assetServiceFactory.getService(assetType);
        return (List<Asset>) service.findAll();
    }

    @PutMapping("/{assetType}/{id}")
    public <T extends Asset> T updateAsset(@PathVariable AssetType assetType, @PathVariable Long id, @RequestBody T asset) {
        GenericAssetServiceImpl<T> service = assetServiceFactory.getService(assetType);
        asset.setId(id);
        return service.update(asset);
    }

    @DeleteMapping("/{assetType}/{id}")
    public void deleteAsset(@PathVariable AssetType assetType, @PathVariable Long id) {
        GenericAssetServiceImpl<? extends Asset> service = assetServiceFactory.getService(assetType);
        service.delete(id);
    }

}
