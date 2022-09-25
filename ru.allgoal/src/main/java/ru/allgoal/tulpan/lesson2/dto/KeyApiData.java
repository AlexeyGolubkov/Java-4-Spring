package ru.allgoal.tulpan.lesson2.dto;

//import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
//import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

public class KeyApiData {

private static int number=0;
    private int id;
    private String userName;
    private String registrationData;
    private String hashValue;


    public KeyApiData() {
        this.id = ++number;
/*        System.out.println(id);
        Faker faker=new Faker();
        this.userName = faker.funnyName().name();
        Date date = new Date();
        this.registrationData = date.toString();
        System.out.println(registrationData);*/
        this.hashValue = hashValueFunction(hashValue);
    }

    private String hashValueFunction(String hashValue) {

        return ""; //encode ((java.lang.CharSequence)new StringBuilder(hashValue+getRegistrationData()+getUserName()+getId()));
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegistrationData() {
        return registrationData;
    }

    public void setRegistrationData(String registrationData) {
        this.registrationData = registrationData;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }
}
