package app.libres.repository;

import app.libres.model.LocationModel;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<LocationModel, Long> {

    List<LocationModel> findAll();

    @Modifying
    @Query(value = "DELETE FROM location WHERE created_time < (NOW() - INTERVAL 3 MINUTE);", nativeQuery = true)
    void deleteOldLocations();
}
