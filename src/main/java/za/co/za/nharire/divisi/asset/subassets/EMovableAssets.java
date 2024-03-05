package za.co.za.nharire.divisi.asset.subassets;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.za.nharire.divisi.asset.model.Asset;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class EMovableAssets extends Asset {

    @Column(name = "assert_type")
    private String assertType;

    @Column(name = "capacity")
    private BigDecimal  capacity;

    @Column(name = "capacity_type")
    private String capacityType;

}

