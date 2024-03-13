package za.co.za.nharire.divisi.farmer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.za.nharire.divisi.common.BaseEntity;
import za.co.za.nharire.divisi.project.models.Project;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "farmers", indexes = {@Index(name = "indx_farmers", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Farmer extends BaseEntity {

    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "preffered_name", nullable = false, length = 45)
    private String prefferedName;


    @Column(name = "id_number", unique = true, nullable = false, length = 10)
    private String idNumber;

    @Column(name = "msisdn", unique = true, nullable = false, length = 12)
    private String msisdn;

    @Column(name = "address")
    private String address;

    @Column(name = "village_id")
    private Long villageId;

    @Column(name = "longitude", length = 45)
    private String longitude;

    @Column(name = "latitude", length = 45)
    private String latitude;

    @Column(name = "farmer_type", length = 100)
    private String farmerType;

    @Column(name = "specialisation", length = 100)
    private String specialisation;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

}
