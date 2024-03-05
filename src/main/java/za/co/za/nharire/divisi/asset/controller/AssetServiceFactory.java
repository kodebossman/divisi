package za.co.za.nharire.divisi.asset.controller;
import za.co.za.nharire.divisi.asset.model.Asset;

import za.co.za.nharire.divisi.asset.service.GenericAssetServiceImpl;
import za.co.za.nharire.divisi.asset.subassets.EMovableAssets;
import za.co.za.nharire.divisi.asset.subassets.Machinery;
import za.co.za.nharire.divisi.asset.subassets.Vehicle;
import za.co.za.nharire.divisi.enums.AssetType;

import java.util.HashMap;
import java.util.Map;

public class AssetServiceFactory {

    private final Map<AssetType, GenericAssetServiceImpl<? extends Asset>> serviceMap = new HashMap<>();

    public AssetServiceFactory(GenericAssetServiceImpl<Machinery> machineryService,
                               GenericAssetServiceImpl<Vehicle> vehicleService,
                               GenericAssetServiceImpl<EMovableAssets> emovableAssetsService) {
        serviceMap.put(AssetType.MACHINERY, machineryService);
        serviceMap.put(AssetType.VEHICLE, vehicleService);
        serviceMap.put(AssetType.EMOVABLE_ASSETS, emovableAssetsService);
    }

    public <T extends Asset> GenericAssetServiceImpl<T> getService(AssetType assetType) {
        // Cast is safe because we know the exact type at runtime
        return (GenericAssetServiceImpl<T>) serviceMap.get(assetType);
    }
}
