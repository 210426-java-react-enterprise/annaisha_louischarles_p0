package com.revature.intro.Screens;

import com.revature.intro.daos.UserDao;
import com.revature.intro.models.AppUser;
import com.revature.intro.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.intro.Driver.app;

public class LoginScreen extends Screen {

    BufferedReader br;
    ScreenRouter router;
    UserDao userDao;

    public LoginScreen(BufferedReader br, ScreenRouter router) { //Buffered just reads, and wraps around another reader.
        //super("LoginScreen","/login");
        super("LoginScreen", "/login");
        this.br = br;
        this.router = router;
        userDao = new UserDao();// need to invoke a dependency injection with this and all screens
    }

    public void render() { //show to the browser window

        try {
            String username; //string recognizes user and password
            String password;
            System.out.println("Welcome Back Hero! Its an honor, Login Below:");  //welcome screen
            System.out.println("+-------------------------+");

            System.out.print("Username: ");
            username = br.readLine(); //getting data from user

            System.out.print("Password: ");
            password = br.readLine(); //getting data from user


            //add more constraints to login
            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) { //Validate its not blank entries!

                AppUser approvedUser = userDao.findUserByUsernameAndPassword(username, password);
                if (approvedUser != null) { //
                    System.out.println("Login Successful!"); //this is the result of a completed welcome screen /login path
                    //render method invocation
                    router.navigate("/transaction");
                } else {
                    System.out.println("Login failed."); // once either successful or failed this method is complete
                    //and goes back to where it was invoked from at WelcomeScreen router.navigate("/login")
                }
            } else {
                System.out.println("Oh hero.. you have valid contributions to society, but it looks like you didn't provide valid credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Credentials Really, Not Found! Please retry."); // include this line while developing/debugging the app!
            // should be logged to a file in a production environment
        }

    }
}




