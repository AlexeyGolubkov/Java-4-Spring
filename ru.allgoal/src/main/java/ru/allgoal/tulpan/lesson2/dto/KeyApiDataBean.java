package ru.allgoal.tulpan.lesson2.dto;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;


@Configuration
public class KeyApiDataBean {


    @Bean (name="userApiDataBean")
    @Lazy
    public KeyApiData getApiDataBean (String keyApi)
    {
        KeyApiData keyApiData=new KeyApiData();
        int number=keyApiData.getNumber();
        keyApiData.setId(number++);
 return keyApiData;
    }

}
