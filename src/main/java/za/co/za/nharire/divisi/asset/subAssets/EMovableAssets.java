package za.co.za.nharire.divisi.asset.subAssets;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.za.nharire.divisi.asset.model.Asset;

import java.math.BigDecimal;

@Entity
@Table(name = "emovable_assets")
@Getter
@Setter
@ToString(callSuper = true)
public class EMovableAssets extends Asset {

    @Column(name = "land_area")
    private BigDecimal landArea;

    @Column(name = "water_source")
    private String waterSource;


}

