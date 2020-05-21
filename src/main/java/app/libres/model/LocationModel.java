package app.libres.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "location")
@EqualsAndHashCode(callSuper = false)
public class LocationModel extends DataAccessObject {

    private Double longitude;
    private Double latitude;
}
