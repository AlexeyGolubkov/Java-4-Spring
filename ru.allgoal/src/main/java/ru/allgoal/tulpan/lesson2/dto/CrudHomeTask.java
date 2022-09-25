package ru.allgoal.tulpan.lesson2.dto;

//import com.github.javafaker.Faker;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class CrudHomeTask {
    Map<String, KeyApiData> dataKeyApi = new HashMap<>();
    @PostConstruct
    void init() {
/*
        Faker faker=new Faker();
        dataKeyApi.put(faker.funnyName().name(), new KeyApiData());
*/
//        Person person = RandomPerson.get().next();
    }
}
