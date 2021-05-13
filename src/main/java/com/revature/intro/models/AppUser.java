package com.revature.intro.models;


public class AppUser { //this is a pojo with getters and setters
    /**
     *
     */

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

    /**
     * Defines the fields and methods(getters and setters) that compose a user.
     *
     * @param heroStatus- this is a value to prequalify to make an account, that the user be a citizen or a hero.
     * @param firstName - user's personal information.
     * @param lastName
     * @param age
     * @param email
     * @param username
     * @param password
     */
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

    /**
     *
     * @return returns username
     */
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
        if (heroStatus.equalsIgnoreCase("villian") ){System.out.println("Sorry, per our protection clause, " +
                "villians are not allowed to register..please rob another institution.");} else

        return heroStatus;
        return null;
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
