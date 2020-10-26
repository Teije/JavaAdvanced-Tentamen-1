package nl.inholland.oefententamen.TeijeVanHemert;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class TeijeVanHemertApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TeijeVanHemertApplication.class, args);
		//Issue:
		// Cannot resolve symbol 'log'
		//Fix:
		// File > Settings > Plugins > Search 'Lombok' & Install
		log.info("--- Exam Question 1 completed ---");
	}
}
