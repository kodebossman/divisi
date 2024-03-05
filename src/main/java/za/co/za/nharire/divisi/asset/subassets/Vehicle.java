package za.co.za.nharire.divisi.asset.subassets;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import za.co.za.nharire.divisi.asset.model.Asset;

@Entity

@Data
@ToString(callSuper = true)
public class Vehicle extends Asset {

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "engine_capacity")
    private double engineCapacity;

    @Column(name = "color")
    private String color;

    @Column(name = "registration_number")
    private String registrationNumber;


}
