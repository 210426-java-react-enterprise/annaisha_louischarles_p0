package com.revature.intro;

import com.revature.intro.Screens.LoginScreen;
import com.revature.intro.Screens.RegisterScreen;
import com.revature.intro.util.AppState;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

   //must make this one thing static in the main method, becuase its the only way the static main can see it.
    //will run prior to main method.
    public static AppState app = new AppState();

    public static void main(String[] args) {
        while(app.isAppRunning()){
            app.getRouter().navigate("/welcome");//this navigate method calls the welcome screens render method!! know this.
        }

        //AppUser brandNewUser = new AppUser("Al", "Capone","acapone@yahoo.com","acapone", "notSketchy", "01_17_1899", 88);

        //try with resources, catches the exception and closes the BufferedReader
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            RegisterScreen registerScreen = new RegisterScreen(br);
//            registerScreen.render();
//            LoginScreen loginScreen = new LoginScreen(br);
//            loginScreen.render();
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static AppState getApp() { //this was statically imported by WelcomeScreen
        //see top imports there. This mimics as if you placed this getting over there. AND the
        //static main method cannot reference the app if this is not static.
        return app;//its just a getter for the app.
    }
}
