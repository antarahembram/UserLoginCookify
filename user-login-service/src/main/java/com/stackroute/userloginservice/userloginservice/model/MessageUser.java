package com.stackroute.userloginservice.userloginservice.model;

public class MessageUser {

    private String username;
    private String name;
    private String gender;
    private String emailId;
    private String country;
    private String state;
    private String city;

    public MessageUser(String username, String name,String gender, String emailId, String country, String state, String city) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.emailId = emailId;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }
}
