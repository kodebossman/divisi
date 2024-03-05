package za.co.za.nharire.divisi.asset.subassets;
import lombok.Data;
import lombok.ToString;
import za.co.za.nharire.divisi.asset.model.Asset;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Data
@ToString(callSuper = true)

public class Machinery extends Asset {

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "power_rating")
    private String powerRating;

    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;

    @Column(name = "millage")
    private Double millage;


}
