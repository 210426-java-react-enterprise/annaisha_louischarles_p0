package com.revature.intro.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class AppUser { //this is a pojo with getters and setters

    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private LocalDate dob;
    private String heroStatus;


    public AppUser() {
        super();
    }


    public AppUser(String firstName, String lastName, String email,
                   String username, String password, LocalDate dob, String heroStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.heroStatus = heroStatus;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username; // can also have restrictions on entries from users. like length etc.
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() { //format of yyyy/dd/month was not my first choice but provided I could not use java util. Date
        return dob.toString();
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setId(String customerId) {
        this.customerId = customerId;
    }

    public String getHeroStatus() {
        return heroStatus;
    }

    public void setHeroStatus(String heroStatus) {
        this.heroStatus = heroStatus;
    }

    public String toFileString() {
        return String.format(";%s;%s;%s;%s;%s;%s;%d", firstName, lastName, username, password, email, dob);
    }


}

//the equivalent to the above is
//  @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("AppUser{");
//        sb.append("id=").append(id);
//        sb.append(", username='").append(username).append('\'');
//        sb.append(", password='").append(password).append('\'');
//        sb.append(", email='").append(email).append('\'');
//        sb.append(", firstName='").append(firstName).append('\'');
//        sb.append(", lastName='").append(lastName).append('\'');
//        sb.append(", age=").append(age);
//        sb.append('}');
//        return sb.toString();