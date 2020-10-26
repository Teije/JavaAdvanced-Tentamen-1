package nl.inholland.oefententamen.TeijeVanHemert.service;

import nl.inholland.oefententamen.TeijeVanHemert.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService
{
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }
}
