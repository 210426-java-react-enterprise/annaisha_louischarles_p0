package com.revature.intro.util;

import com.revature.intro.Screens.Screen;

public class ScreenRouter {

    private LinkedList<Screen> screens = new LinkedList<Screen>();

    public ScreenRouter addScreen(Screen screen) { //
        screens.add(screen);
        return this;
    }//Builder pattern, will return instance of screen router for future chaining.

    public void navigate(String route) {
        for (int i = 0; i < screens.size(); i++) { //add in a path for /Login or /Register or /Dashboard
            //the alternative to iterable used in util.
            Screen screen = screens.get(i); //grab a screen out the linked list and be like, this what you need? nah okay move on.
            if (screen.getRoute().equals(route)) { //note that this is calling screen not screens.
                screen.render();
                //get(i) on linkedlist will get you a screen, with that in hand you can getRoute from Screen.java,
                //If the culmination of the screen and route of the screen equals the parameters of navigate
                //you can do just that.and invoke that screens render method.
            }

        }
    }
}
//    protected String name;
//    protected String route;
//
//    public void Screen(String name, String route) {
//        this.name = name;
//        this.route = route;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getRoute() {
//        return route;
//    }
//
//    public abstract void render();

