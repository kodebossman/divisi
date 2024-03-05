package za.co.za.nharire.divisi.asset.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import za.co.za.nharire.divisi.asset.subAssets.EMovableAssets;
import za.co.za.nharire.divisi.asset.subAssets.Machinery;
import za.co.za.nharire.divisi.asset.subAssets.Vehicle;
import za.co.za.nharire.divisi.enums.AssetType;
import za.co.za.nharire.divisi.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "assets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "asset_type")
@Getter
@Setter
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "assetType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Machinery.class, name = "MACHINERY"),
        @JsonSubTypes.Type(value = Vehicle.class, name = "VEHICLE"),
        @JsonSubTypes.Type(value = EMovableAssets.class, name = "EMOVABLE_ASSETS")
})
public abstract class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_type", insertable = false, updatable = false)
    private AssetType assetType;
    private BigDecimal value;
    private Long farmerId;

    public Asset() {

        this.updatedAt = new Date();
        this.status = Status.ACTIVE; // Default status
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}




