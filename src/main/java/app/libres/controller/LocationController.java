package app.libres.controller;

import app.libres.model.LocationModel;
import app.libres.service.LocationService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public LocationDTO getLocations() {
        List<LocationModel> locations =  locationService.fetchAllLocations();
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLocations(new ArrayList<>(locations));
        return locationDTO;
    }

    @PostMapping("/location/add")
    @ResponseStatus(CREATED)
    public void addLocation(@Valid @RequestBody LocationModel locationModel) {
        locationService.addLocation(locationModel);
    }

    @PostMapping("/location/addall")
    @ResponseStatus(CREATED)
    public void addAllLocation(@Valid @RequestBody List<LocationModel> locationModel) {
        locationService.addLocation(locationModel);
    }

    @DeleteMapping("/location/thanos")
    public void deleteAllLocations(){
        locationService.deleteAllLocations();
    }

}
