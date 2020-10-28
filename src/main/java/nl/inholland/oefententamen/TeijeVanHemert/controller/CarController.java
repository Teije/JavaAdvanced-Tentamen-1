package nl.inholland.oefententamen.TeijeVanHemert.controller;

import lombok.extern.java.Log;
import nl.inholland.oefententamen.TeijeVanHemert.dto.CarDTO;
import nl.inholland.oefententamen.TeijeVanHemert.dto.GenericErrorResponseDTO;
import nl.inholland.oefententamen.TeijeVanHemert.model.Car;
import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import nl.inholland.oefententamen.TeijeVanHemert.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // Note Exam Question 5b Endpoint
    // Link to test: https://localhost:8443/cars?hasWon=true
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"hasWon"})
    public ResponseEntity<List<Car>> getCarsWithOrWithoutWinners(@RequestParam Boolean hasWon) {
        List<Car> cars = carService.GetCarsWithOrWithoutWinners(hasWon);
        log.info("--- Exam Question 5b completed ---");

        return ResponseEntity
                .status(200)
                .body(cars);
    }

    // Note Postman Input:
    /*
        Call Method: POST
        URL: https://localhost:8443/cars/
        body (JSON/CarDTO):
            {
                "brand": "Mercedes",
                "driverId": "1000004"
            }
        response (JSON/Car)
            {
                "id": 9000004,
                "brand": "Mercedes",
                "topSpeed": 252,
                "driver":
                {
                    "id": 1000004,
                    "firstName": "Max",
                    "lastName": "Vierstappen",
                    "ranking": "SENNA",
                    "age": 22,
                    "wonBefore": false
                }
            }
     */
    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity CreateCar(@RequestBody CarDTO carDTO)
    {
        try
        {
            log.info("--- Exam Question 6a completed ---");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(carService.createCar(carDTO));
        }
        //
        catch (Exception exception)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new GenericErrorResponseDTO(400, exception.getMessage()));
        }
    }
}
