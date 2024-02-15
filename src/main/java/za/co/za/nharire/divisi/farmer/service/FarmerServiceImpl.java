package za.co.za.nharire.divisi.farmer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.za.nharire.divisi.farmer.model.Farmer;
import za.co.za.nharire.divisi.farmer.model.dto.FarmerDTO;
import za.co.za.nharire.divisi.farmer.repos.FarmerRepository;
import za.co.za.nharire.divisi.location.Village;
import za.co.za.nharire.divisi.location.repository.VillageRepository;
import za.co.za.nharire.divisi.util.DivisiUtil;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;
    private final VillageRepository villageRepository;

    @Override
    public FarmerDTO createFarmer(FarmerDTO farmerDTO) {

        log.info("In Service ...");

        Farmer farmer = new Farmer();
        BeanUtils.copyProperties(farmerDTO, farmer);

        log.info(" Created Farmer {} ", DivisiUtil.logData(farmerDTO));

        Village village = new Village();
        BeanUtils.copyProperties(farmerDTO.getVillage(), village);

        log.info(" Created Village {} ", DivisiUtil.logData(village));

        //save village to db
        try {
            village = villageRepository.save(village);
        } catch (Exception exception) {

            log.info(" FAILED TO SAVE VILLAGE {} ", exception.getMessage());
        }

        farmer.setVillageId(village.getId());

        try{
            farmer = farmerRepository.save(farmer);
        }catch (Exception exception){
            log.error(" FAILED TO SAVE FARMER IN DB {}",exception.getMessage());
        }

        BeanUtils.copyProperties(farmer,farmerDTO);
        BeanUtils.copyProperties(village,farmerDTO.getVillage());

        return farmerDTO;
    }
}
