package ru.allgoal.tulpan.lesson2.dto;


import net.datafaker.Faker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.allgoal.tulpan.Main;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/user")
public class CrudHomeTask {
    Map<String, KeyApiData> dataKeyApiMap = new HashMap<>();

    @PostConstruct
    void init() {

        String keyApi;
        for(int i=0;i<8;i++)
        {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KeyApiDataBean.class);

/*            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


            keyApi = passwordEncoder.encode(faker.address().toString()).substring(10).replaceAll("/", "K");
  */        keyApi= Main.generationApiKey();
            Faker faker = new Faker();
            KeyApiData keyApiData = (KeyApiData) ctx.getBean("userApiDataBean", keyApi);
            String name=faker.funnyName().name().replaceAll("\\s", "");
            if (name.length()<8) {

               for(int k=name.length();k<8;k++){name=name+"_";}

            }
            keyApiData.setUserName(name.substring(0, 8));
            keyApiData.setId(keyApiData.getNumber());
            keyApiData.setNumber(keyApiData.getNumber()+1);
            Date date = new Date();
            keyApiData.setRegistrationData(date.toString());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            keyApiData.setHashValue(passwordEncoder.encode(keyApiData.getRegistrationData()+keyApiData.getUserName()+keyApiData.getId()+keyApi));

            //System.err.println(name);
            System.out.println("API:" + keyApi + "->" + keyApiData.toString());

            dataKeyApiMap.put(keyApi, keyApiData);
        }
    }
    @GetMapping("/{id}")
    public KeyApiData get(@PathVariable int id) {
        return dataKeyApiMap.get(id);
    }

    @GetMapping("/all")
    public List<String> get() {
        return dataKeyApiMap.entrySet().parallelStream().collect(ArrayList::new,
                (list, element) -> list.add(element.toString()), ArrayList::addAll);
        //return new ArrayList<>(dataKeyApiMap.values());
    }

    @PutMapping()
    public void save(@RequestBody KeyApiData user) {
        int id = dataKeyApiMap.size() + 1;
        user.setNumber(user.getNumber()+1);
        user.setId(id);
        //---todo
        dataKeyApiMap.put(Main.generationApiKey(), user);
    }

    @PostMapping("/{id}")
    public void change(@PathVariable String apiKey) {
        KeyApiData user = dataKeyApiMap.get(apiKey);
        user.setUserName("AlexGoal");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String apiKey) {
        dataKeyApiMap.remove(apiKey);
    }
}