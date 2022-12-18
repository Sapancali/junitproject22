package com.arcane;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day03_C7_JavaFaker {
    //cogunlukla test için fake data kullanırız
    // JavaFaker de fake data kullanmak için oluşturulmuştur
    //java fake dependency i pox.xml e eklemiştik
    @Test
    public void fakerTest(){
        //1. Faker data type de object oluştur
        Faker faker=new Faker();

        //2. Ardından faket data kullanabiliriz: first, lastname, adres, city, state, country
        String fName=faker.name().firstName();
        System.out.println(fName);

        String lName= faker.name().lastName();
        System.out.println(lName);

        String fullName= faker.name().fullName();
        System.out.println(fullName);

        //title
        System.out.println(faker.name().title());

        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //phone number
        System.out.println(faker.phoneNumber().cellPhone());

        //postcode/zipcode
        System.out.println(faker.address().zipCode());

        //rastgele email adres
        System.out.println(faker.internet().emailAddress());

        //rastgele rakam
        System.out.println(faker.number().digits(6));

        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.animal().name());

        System.out.println(faker.avatar().image());
        System.out.println(faker.superhero().name());
    }
}
