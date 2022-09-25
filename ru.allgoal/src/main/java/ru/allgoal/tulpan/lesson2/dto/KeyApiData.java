package ru.allgoal.tulpan.lesson2.dto;

public class KeyApiData {

    public static int getNumber() {
        return number;
    }
    public static void setNumber(int number) {
        KeyApiData.number = number;
    }
    private static int number=0;
    private int id;
    private String userName;
    private String registrationData;
    private String hashValue;




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


    @Override
    public String toString(){
        return ">id="+id+"; user="+userName;
    }


}