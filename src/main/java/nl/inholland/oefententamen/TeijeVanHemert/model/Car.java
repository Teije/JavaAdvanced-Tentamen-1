package nl.inholland.oefententamen.TeijeVanHemert.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Random;

//Issue:
// Not a managed type: class nl.inholland.oefententamen.TeijeVanHemert.model.Driver
//Fix:
// Make sure all classes have the correct @Entity, @Component, @Controller, @Repository, etc?

//Issue:
// No default constructor for entity:  : nl.inholland.oefententamen.TeijeVanHemert.model.Driver
//Fix:
// Add the Lombok annotation: @NoArgsConstructor above the entity causing the problem

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car
{
    @Id
    @SequenceGenerator(name = "car_seq", initialValue = 9000001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    private long id;

    String brand;
    int topSpeed;

    @OneToOne
    private Driver driver;

    public Car(String brand, Driver driver)
    {
        this.brand = brand;
        this.topSpeed = new Random().nextInt(50) + 250;;
        this.driver = driver;
    }


}
