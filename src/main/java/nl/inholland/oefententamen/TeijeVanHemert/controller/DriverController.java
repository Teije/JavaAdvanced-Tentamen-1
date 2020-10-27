package nl.inholland.oefententamen.TeijeVanHemert.controller;

import lombok.extern.java.Log;
import nl.inholland.oefententamen.TeijeVanHemert.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    
}
