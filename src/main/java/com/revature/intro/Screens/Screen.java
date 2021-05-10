package com.revature.intro.Screens;

public abstract class Screen {
    //abstracts do have constructors.You never call it directly unless its a rare local anonymous class.
//    private LinkedList<Screen> screens = new LinkedList<>();
//
//    public Screen addScreen(Screen screen) {
//        screens.add(screen);
//        return this;
    protected String name; //subclasses will have access these values directly, no need to get
    protected String route;

    public Screen(String name, String route) { //this is the super constructor for every child.
        //the following parameters be defined: name of Screen and name of Rout to screen
        this.name = name;
        this.route = route;
    }

    public String getName() { //everything in here is private except for the getter, so that subclasses dont need the details.
        return name;
    }


    public String getRoute() {
        return route;
    }

    public abstract void render();
}
