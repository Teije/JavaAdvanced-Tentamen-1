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

		// Note Assignment 4 - Beveilig de applicatie met HTTPS
        /*
        Beveilig de applicatie met een PKCS12-keystore genaamd f1.p12 welke de volgende eigenschappen heeft:
            o Password: formulaOne
            o Alias: f1
            o Algorithm: RSA
            o Valid: 365 days
            o First and last name: <jouw-naam>
            o Organizational Unit: The Stable
            o Name of Organization: FormulaOne
            o City: Zandvoort
            o State or province: Noord-Holland
            o Country Code: NL
        ☐ Run de applicatie op port 8443

        Command to create a keystore
        > keytool -genkey -alias f1 -keyalg RSA -validity 365 -keystore f1.p12 -storetype PKCS12

        Store the following lines to the application.properties file (create it if it does not yet exist in the root of the project)
            server.port = 8443 # Now the server listens on 8443 instead of 8080
            server.ssl.key-store=f1.p12
            server.ssl.key-store-type=PKCS12
            server.ssl.key-alias=f1
            server.ssl.key-store-password=formulaOne
         */
		log.info("--- Exam Question 4 completed ---");
	}
}
