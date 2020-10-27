package nl.inholland.oefententamen.TeijeVanHemert.service;

import nl.inholland.oefententamen.TeijeVanHemert.model.Car;
import nl.inholland.oefententamen.TeijeVanHemert.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    private CarRepository carRepository;

    public CarService(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    public List<Car> GetCarsWithOrWithoutWinners(boolean hasWon) {
        return carRepository.findCarsWithOrWithoutWinners(hasWon);
    }
}
