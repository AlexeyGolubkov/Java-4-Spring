package ru.allgoal.tulpan.lesson2.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import com.github.javafaker.Faker;
import java.util.Date;

@Configuration
public class SpringConfig {

    @Bean
    public KeyApiData GenerationUser (int id,
    String userName,
    String registrationData,
    String hashValue)
    {

            id = id+1;
            System.out.println(id);
/*            Faker faker=new Faker();
            userName = faker.funnyName().name();
            Date date = new Date();
            registrationData = date.toString();
            System.out.println(registrationData);

            this.hashValue = hashValue;*/


        return null;
    }
}
