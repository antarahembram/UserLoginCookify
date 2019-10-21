package com.stackroute.userloginservice.userloginservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Registration_Details")
public class DAOUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private String emailId;
    @Column
    private String country;
    @Column
    private String state;
    @Column
    private String city;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getEmailId() { return emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }
}
