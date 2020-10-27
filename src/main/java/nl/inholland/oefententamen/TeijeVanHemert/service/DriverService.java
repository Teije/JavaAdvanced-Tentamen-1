package nl.inholland.oefententamen.TeijeVanHemert.service;

import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import nl.inholland.oefententamen.TeijeVanHemert.repository.DriverRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DriverService
{
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }

    public Driver GetDriverById(long id)
    {
        var driver = driverRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No driver could be found with this id: " + id));

        return driver;
    }
}
