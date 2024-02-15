package za.co.za.nharire.divisi.farmer.model.dto;

import lombok.Data;
import za.co.za.nharire.divisi.common.BaseDto;
@Data
public class FarmerDTO extends BaseDto {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String msisdn;
    private String address;
    private Long villageId;
    private String longitude;
    private String latitude;
    private String farmerType;
    private String specialisation;
    private VillageDTO village;
}
