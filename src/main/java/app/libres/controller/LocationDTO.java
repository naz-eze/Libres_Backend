package app.libres.controller;

import app.libres.model.LocationModel;
import java.util.List;

public class LocationDTO {

    private List<LocationModel> locations;

    public List<LocationModel> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationModel> locations) {
        this.locations = locations;
    }
}
