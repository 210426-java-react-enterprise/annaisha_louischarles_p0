package com.revature.intro.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class AppUser { //this is a pojo with getters and setters


    private int customerId;
    private String heroStatus;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
    private String password;


    public AppUser(AppUser brandNewUser) {
        super();
    }


    public AppUser(String heroStatus, String firstName, String lastName, int age, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
        this.heroStatus = heroStatus;

    }

    public AppUser() {
        super();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getHeroStatus() {
        return heroStatus;
    }

    public void setHeroStatus(String heroStatus) {
        this.heroStatus = heroStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppUser{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", heroStatus='").append(heroStatus).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

//    public String toFileString() {
//        return String.format(";%s;%s;%s;%s;%s;%d;%s", firstName, lastName, username, password, email, dob, heroStatus);
//
//
//    } //same as string builder above.


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