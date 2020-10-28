package nl.inholland.oefententamen.TeijeVanHemert.service;

import nl.inholland.oefententamen.TeijeVanHemert.dto.CarDTO;
import nl.inholland.oefententamen.TeijeVanHemert.model.Car;
import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import nl.inholland.oefententamen.TeijeVanHemert.repository.CarRepository;
import nl.inholland.oefententamen.TeijeVanHemert.repository.DriverRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarService
{
    private CarRepository carRepository;
    private DriverRepository driverRepository;

    public CarService(CarRepository carRepository, DriverRepository driverRepository)
    {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
    }

    public List<Car> GetCarsWithOrWithoutWinners(boolean hasWon) {
        return carRepository.findCarsWithOrWithoutWinners(hasWon);
    }

    public Car CreateCar(CarDTO carDTO) {
        Driver driver = driverRepository
                .findById(carDTO.getDriverId())
                .orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        Car car = new Car(carDTO.getBrand(), driver);
        return carRepository.save(car);
    }

    public int GetTotalSpeed()
    {
        List<Car> cars = (List<Car>) carRepository.findAll();
        return cars.stream()
                .mapToInt(Car::getTopSpeed)
                .sum();
    }
}
