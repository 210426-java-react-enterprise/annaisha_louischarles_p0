package com.revature.intro.Screens;

import com.revature.intro.daos.UserDao;
import com.revature.intro.exceptions.InvalidRequestException;
import com.revature.intro.exceptions.ResourcePersistenceException;
import com.revature.intro.models.AppUser;
import com.revature.intro.services.UserService;
import com.revature.intro.util.ScreenRouter;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegisterScreen extends Screen {

    // Class Variables

    private UserDao userdao; //put this instantiation somewhere shared between all screens and then pass this into the constructor
    //all screens using the userdao! Dependency injection

    public BufferedReader br; //this reference here is for the method invocation below, so that it recognizes variable

    private AppUser brandNewUser;
    private UserService userService;

    // Constructor

    public RegisterScreen(BufferedReader br, ScreenRouter router, UserService userService) {
        super("RegisterScreen", "/register");
        this.userService = userService;
        this.userdao = new UserDao();
        this.br = br;
    }

    public void render() {
        String firstName;
        String lastName;
        String email;
        String username;
        String password;
        String heroStatus;
        int age;

        try {
            //risky code might throw exception

            System.out.println("Please register for a new account below");
            System.out.println("+------+------+--------+------+ \n");


            System.out.println("First things first, are you a civilian, hero or a villian?");
            heroStatus = br.readLine() ;
//            if(userService.isUserValid(user))
//            return;
//            ;
            System.out.print("First Name: ");
            firstName = br.readLine();

            System.out.print("Last Name: ");
            lastName = br.readLine();

            System.out.print("How old are you? ");
            age = Integer.parseInt(br.readLine());

            System.out.print("Email: ");
            email = br.readLine();

            System.out.print("Enter Username: ");
            username = br.readLine();

            System.out.print("Enter Password: ");
            password = br.readLine();

            //public AppUser(String firstName, String lastName, String email, String username, String password,
            //     String dob, String currentStatus) {

            AppUser brandNewUser = new AppUser(heroStatus, firstName, lastName, age, email, username, password);
            userService.register(brandNewUser);
            //cool product of dependency injection.
            //System.out.println("Before save:  " + brandNewUser);
            //userdao.save(brandNewUser);
            //System.out.println("After save: " + brandNewUser); //So you defined appUser and what that looks like to register
//            //screen. Now here you are saying in userdao there is a method that saves, pass in what you've defined as newUser
//            //to that save method.
            System.out.println("You have been registered, welcome " + username + "!");
            System.out.println("\n +------+------+--------+------+\n");

        } catch (DateTimeParseException e)      //LocalDate.parse exception
        {
            System.err.println("You provided an incorrect value :( Please try again.");
            this.render(); //this breaks stuff will need to fix later.

        } catch (InvalidRequestException | ResourcePersistenceException e) {
            //e.printStackTrace();
            System.out.println("RegisterScreen -- InvalidRequestException! Invalid new user data provided.");
        } catch (Exception e) {
           // e.printStackTrace();
            //System.err.println();
        }
    }
}