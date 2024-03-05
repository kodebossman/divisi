package za.co.za.nharire.divisi.asset.controller;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.za.nharire.divisi.asset.service.GenericAssetServiceImpl;
import za.co.za.nharire.divisi.asset.subassets.EMovableAssets;
import za.co.za.nharire.divisi.asset.subassets.Machinery;
import za.co.za.nharire.divisi.asset.subassets.Vehicle;


@Configuration
public class AppConfig {

    @Bean
    public AssetServiceFactory assetServiceFactory(GenericAssetServiceImpl<Machinery> machineryService,
                                                   GenericAssetServiceImpl<Vehicle> vehicleService,
                                                   GenericAssetServiceImpl<EMovableAssets> emovableAssetsService) {
        return new AssetServiceFactory(machineryService, vehicleService, emovableAssetsService);
    }
}
