package nl.inholland.oefententamen.TeijeVanHemert.controller;

import lombok.extern.java.Log;
import nl.inholland.oefententamen.TeijeVanHemert.model.Car;
import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import nl.inholland.oefententamen.TeijeVanHemert.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log
@Controller
@RequestMapping(value = "/cars")
public class CarController
{
    private CarService carService;

    public CarController(CarService carService)
    {
        this.carService = carService;
    }

    //note Link to test: https://localhost:8443/cars?hasWon=true
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"hasWon"})
    public ResponseEntity<List<Car>> getCarsWithOrWithoutWinners(@RequestParam Boolean hasWon) {
        List<Car> cars = carService.GetCarsWithOrWithoutWinners(hasWon);
        log.info("--- Exam Question 5b completed ---");

        return ResponseEntity
                .status(200)
                .body(cars);
    }
}
