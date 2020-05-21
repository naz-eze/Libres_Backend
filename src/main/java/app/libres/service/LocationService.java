package app.libres.service;

import app.libres.model.LocationModel;
import app.libres.repository.LocationRepository;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationService {

    private final static long FIVE_MINS = 5 * 60 * 1000;

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationModel> fetchAllLocations() {
        return locationRepository.findAll();
    }

    public void addLocation(LocationModel location) {
        locationRepository.save(location);
    }

    public void addLocation(List<LocationModel> locations) {
        locationRepository.saveAll(locations);
    }

    @Transactional
    @Scheduled(fixedDelay = FIVE_MINS)
    public void deleteOldLocations() {
        locationRepository.deleteOldLocations();
    }

    public void deleteAllLocations() {
        locationRepository.deleteAll();
    }
}
