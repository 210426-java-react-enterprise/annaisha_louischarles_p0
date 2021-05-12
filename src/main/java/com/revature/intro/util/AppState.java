package com.revature.intro.util;

import com.revature.intro.Screens.LoginScreen;
import com.revature.intro.Screens.RegisterScreen;
import com.revature.intro.Screens.TransactionScreen;
import com.revature.intro.Screens.WelcomeScreen;
import com.revature.intro.daos.UserDao;
import com.revature.intro.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader br;
    private ScreenRouter router;
    private boolean appRunning;
    UserService userService;



    public AppState() {
        System.out.println("Initializing application....");

        this.appRunning = true; //this keyword not necessary, but always use.
        this.br = new BufferedReader(new InputStreamReader(System.in));


        final UserDao userDao = new UserDao();
        final UserService userService = new UserService(userDao); //review this, as register screen req. this instance,
        //but why pass in userdao

        router = new ScreenRouter(); //note you could have also said this.router, like the ones above and vice versa.
        router.addScreen(new WelcomeScreen(br, router))
                .addScreen(new LoginScreen(br, router, userService))
                .addScreen(new RegisterScreen(br, router, userService)) //do the same here that you did for Welcome and Login making its instantiation dependent on the router.
                .addScreen(new TransactionScreen(br, router)) //do the same here that you did for Welcome and Login making its instantiation dependent on the router.
                .addScreen(new BankAccount(br, router)); //trying to route a transactions screen from LOGIN.
    }

    public BufferedReader getBr() {
        return br;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) { //need this for WelcomeScreen implementation.
        this.appRunning = appRunning; // not setting the router and buffered reader because its called above.
    //want to flip this on and off like a switch.
    }

}

