package com.revature.intro.Screens;

import com.revature.intro.daos.UserDao;
import com.revature.intro.exceptions.InvalidRequestException;
import com.revature.intro.exceptions.ResourcePersistenceException;
import com.revature.intro.models.AppUser;
<<<<<<< HEAD
import com.revature.intro.services.UserService;
=======
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
import com.revature.intro.util.ScreenRouter;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegisterScreen extends Screen {

    // Class Variables

    private UserDao userdao; //put this instantiation somewhere shared between all screens and then pass this into the constructor
    //all screens using the userdao! Dependency injection
<<<<<<< HEAD
    public BufferedReader br; //this reference here is for the method invocation below, so that it recognizes variable

    private AppUser user;
    private UserService userService;
=======
    private BufferedReader br; //this reference here is for the method invocation below, so that it recognizes variable

>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
    // Constructor

    public RegisterScreen(BufferedReader br, ScreenRouter router) {
        super("RegisterScreen", "/register");

        this.userdao = new UserDao();
        this.br = br;
    }

    public void render() {
        String firstName;
        String lastName;
        String email;
        String username;
        String password;
<<<<<<< HEAD
        String heroStatus;
=======
        String currentStatus;
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
        LocalDate dob;

        try {
            //risky code might throw exception

            System.out.println("Please register for a new account below");
            System.out.println("+------+------+--------+------+ \n");

<<<<<<< HEAD
            System.out.println("First things first, are you a civilian, hero or a villian?");
            heroStatus = br.readLine() ;
//            if(userService.isUserValid(user))
//            return;
//            ;
=======
            System.out.println("First things first, are you a hero or a villian?");
            currentStatus = br.readLine();
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173

            System.out.print("First Name: ");
            firstName = br.readLine();

            System.out.print("Last Name: ");
            lastName = br.readLine();

            System.out.print("Enter date of birth yyyy-mm-dd: ");
            dob = LocalDate.parse(br.readLine());

            System.out.print("Email: ");
            email = br.readLine();

            System.out.print("Enter Username: ");
            username = br.readLine();

            System.out.print("Enter Password: ");
            password = br.readLine();

            //public AppUser(String firstName, String lastName, String email, String username, String password,
            //     String dob, String currentStatus) {

            AppUser brandNewUser = new AppUser(firstName, lastName, email, username, password,
<<<<<<< HEAD
                    dob, heroStatus);

            System.out.println("You have been registered, welcome " + username + "!");
            System.out.println("\n +------+------+--------+------+\n");

=======
                    dob, currentStatus);

            System.out.println("You have been registered, welcome " + username + "!");
            System.out.println("\n +------+------+--------+------+\n");
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
        } catch (DateTimeParseException e)      //LocalDate.parse exception
        {
            System.err.println("You provided an incorrect value :( Please try again.");
            this.render(); //this breaks stuff will need to fix later.

        } catch (InvalidRequestException | ResourcePersistenceException e) {
            //e.printStackTrace();
            System.out.println("RegisterScreen -- InvalidRequestException!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
        }
    }
}