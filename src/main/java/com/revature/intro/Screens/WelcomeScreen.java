package com.revature.intro.Screens;

import com.revature.intro.util.ScreenRouter;
import com.revature.intro.util.AppState;

import static com.revature.intro.Driver.getApp;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen {
    /**
     * Welcome screen for users to initial experience and navigate the application.
     * Considered the landing page.
     */
    private BufferedReader br;
    private ScreenRouter router;

    public WelcomeScreen(BufferedReader br, ScreenRouter router) { //this is dependency injection!!
        //this class now depends on the two instances above, so much so, we are passing them into the constructors.
        super("WelcomeScreen", "/welcome");
        this.br = br;
        this.router = router; //reference provided to this class when we instantiate it. So its now dependent on it.
    }


    @Override
    public void render() {

        System.out.println("Welcome to Marvel Bank!");
        System.out.println(" 1) Login with existing credentials");
        System.out.println(" 2) Register");
        System.out.println(" 3) Exit application");

        try {
            System.out.println(">>");
            String userSelection = br.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Flying you to login screen...");
                    router.navigate("/login"); //hi, Im coming from driver, just to say this method then calls
                    //the render method of login. once that is complete it comes,
                    break;
                case "2":
                    System.out.println("Chasing you to register screen..");
                    router.navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application, Goodbye and Have a MARVELous day!");
                    //we need to figure out how to tell the app to shutdown.
                    System.out.println("+----------------------------------+");
                    getApp().setAppRunning(false); //will close application properly! Then the render method will be done.
                    //After this render method is complete, it will loop back to Driver under the "while(app.isAppRunning)
                    //which would have been fulfilled and ended. now main method is over.
                    break;
                default:
                    System.out.println("We know you can do extraordinary things, but this was an ordinary Invalid selection! ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
