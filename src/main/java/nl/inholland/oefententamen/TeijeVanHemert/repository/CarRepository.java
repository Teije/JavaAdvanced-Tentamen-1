package nl.inholland.oefententamen.TeijeVanHemert.repository;

import nl.inholland.oefententamen.TeijeVanHemert.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Note: This is an INTERFACE with @Repo & extending from CRUD
@Repository
public interface CarRepository extends CrudRepository<Car, Long>
{


}
