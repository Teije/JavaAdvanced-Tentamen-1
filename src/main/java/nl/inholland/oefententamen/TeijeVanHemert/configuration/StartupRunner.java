package nl.inholland.oefententamen.TeijeVanHemert.configuration;

import lombok.extern.java.Log;
import nl.inholland.oefententamen.TeijeVanHemert.model.Driver;
import nl.inholland.oefententamen.TeijeVanHemert.model.Ranking;
import nl.inholland.oefententamen.TeijeVanHemert.repository.DriverRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@Log
public class StartupRunner implements ApplicationRunner
{
    private DriverRepository driverRepository;

    public StartupRunner(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        List<String> drivers = Files.readAllLines(Paths.get("drivers.csv"));
        drivers.forEach(
                driver ->
                        driverRepository.save(
                                new Driver(
                                    driver.split(",")[0],
                                    driver.split(",")[1],
                                    Ranking.valueOf(driver.split(",")[2]),
                                    Integer.parseInt(driver.split(",")[3]),
                                    Boolean.parseBoolean(driver.split(",")[4])
                                )
                        )

        );

        driverRepository.findAll().forEach(System.out::println);
        log.info("--- Exam Question 2 completed ---");
    }
}
