package ru.allgoal.tulpan;

import net.datafaker.Faker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static String generationApiKey(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Faker faker = new Faker();
        return passwordEncoder.encode(faker.address().toString()).substring(10).replaceAll("/", "K");


    }
}
