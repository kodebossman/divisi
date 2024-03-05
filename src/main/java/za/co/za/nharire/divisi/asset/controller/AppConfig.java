package za.co.za.nharire.divisi.asset.controller;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.za.nharire.divisi.asset.service.GenericAssetServiceImpl;
import za.co.za.nharire.divisi.asset.subAssets.EMovableAssets;
import za.co.za.nharire.divisi.asset.subAssets.Machinery;
import za.co.za.nharire.divisi.asset.subAssets.Vehicle;


@Configuration
public class AppConfig {

    @Bean
    public AssetServiceFactory assetServiceFactory(GenericAssetServiceImpl<Machinery> machineryService,
                                                   GenericAssetServiceImpl<Vehicle> vehicleService,
                                                   GenericAssetServiceImpl<EMovableAssets> emovableAssetsService) {
        return new AssetServiceFactory(machineryService, vehicleService, emovableAssetsService);
    }
}
