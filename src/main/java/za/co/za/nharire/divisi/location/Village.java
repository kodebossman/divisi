package za.co.za.nharire.divisi.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import za.co.za.nharire.divisi.common.BaseEntity;

@Entity
@Table(name = "village", indexes = {@Index(name = "indx_villages", columnList = "village_name , ward", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Village extends BaseEntity {

    @Column(name="village_name")
    private String villageName;
    @Column(name="village_head")
    private String villageHead;
    @Column(name="village_head_contact_number")
    private String villageHeadContactNumber;
    @Column(name="province")
    private String province;
    @Column(name="district", length = 50)
    private String district;
    @Column(name="ward", length = 45)
    private int ward;
    @Column(name="chief")
    private String chief;
    @Column(name="region")
    private String region;
    @Column(name="town")
    private String town;
    @Column(name="growth_point")
    private String growthPoint;
    @Column(name="village_type")
    private String villageType;

}
