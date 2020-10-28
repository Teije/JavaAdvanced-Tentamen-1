package nl.inholland.oefententamen.TeijeVanHemert.repository;

import nl.inholland.oefententamen.TeijeVanHemert.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Note: This is an INTERFACE with @Repo & extending from CRUD
@Repository
public interface CarRepository extends CrudRepository<Car, Long>
{
    @Query("select c from Car c, Driver d where c.driver.id = d.id and d.wonBefore = :hasWon")
    List<Car> findCarsWithOrWithoutWinners(boolean hasWon);
}
