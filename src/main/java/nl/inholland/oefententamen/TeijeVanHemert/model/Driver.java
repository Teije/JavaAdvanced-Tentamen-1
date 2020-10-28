package nl.inholland.oefententamen.TeijeVanHemert.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
public class Driver
{
    @Id
    @SequenceGenerator(name = "driver_seq", initialValue = 1_000_001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guitar_seq")
    private long id;
    String firstName;
    String lastName;
    Ranking ranking;
    int age;
    boolean wonBefore;

    public Driver(String firstName, String lastName, Ranking ranking, int age, boolean wonBefore)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ranking = ranking;
        this.age = age;
        this.wonBefore = wonBefore;
    }
}

