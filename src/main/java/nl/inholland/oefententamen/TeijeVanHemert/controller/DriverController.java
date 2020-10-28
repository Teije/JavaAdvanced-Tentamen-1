package nl.inholland.oefententamen.TeijeVanHemert.controller;

import lombok.extern.java.Log;
import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import nl.inholland.oefententamen.TeijeVanHemert.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log
@Controller
@RequestMapping(value = "/drivers")
public class DriverController
{
    public DriverService driverService;

    public DriverController(DriverService driverService)
    {
        this.driverService = driverService;
    }

    // Note Exam Question 5a Endpoint
    // Endpoint to test: https://localhost:8443/drivers/1000001
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity GetDriverById(@PathVariable long id)
    {
        Driver driver = driverService.GetDriverById(id);
        log.info("--- Exam Question 5a completed ---");

        return ResponseEntity
                .status(200)
                .body(driver);
    }
}
