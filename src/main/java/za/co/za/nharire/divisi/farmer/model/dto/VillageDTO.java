package za.co.za.nharire.divisi.farmer.model.dto;

import lombok.Data;
import za.co.za.nharire.divisi.common.BaseDto;

@Data
public class VillageDTO extends BaseDto {

    private String villageName;
    private String villageHead;
    private String villageHeadContactNumber;
    private String province;
    private String district;
    private int ward;
    private String chief;
    private String region;
    private String town;
    private String growthPoint;

}
