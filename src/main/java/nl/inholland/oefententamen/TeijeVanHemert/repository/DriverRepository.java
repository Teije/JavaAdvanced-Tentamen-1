package nl.inholland.oefententamen.TeijeVanHemert.repository;

import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// TODO: This is an INTERFACE with @Repo & extending from CRUD
@Repository
public interface DriverRepository extends CrudRepository<Driver, Long>
{
}
