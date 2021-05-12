package com.revature.intro.services;

import com.revature.intro.daos.UserDao;
import com.revature.intro.exceptions.InvalidRequestException;
import com.revature.intro.exceptions.ResourcePersistenceException;
import com.revature.intro.models.AppUser;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public AppUser register(AppUser newUser) throws InvalidRequestException, ResourcePersistenceException {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid new user data provided!");
        }

        if (!userDao.isUsernameAvailable(newUser.getUsername())) {
            throw new ResourcePersistenceException("The provided username is already taken!");
        }

        if (!userDao.isEmailAvailable(newUser.getEmail())) {
            throw new ResourcePersistenceException("The provided email is already taken!");
        }

        return userDao.save(newUser);

    }

    public boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getUsername() == null || user.getUsername().trim().isEmpty() || user.getUsername().length() > 20)
            return false;
        if (user.getPassword() == null || user.getPassword().trim().isEmpty() || user.getPassword().length() > 255)
            return false;
        if (user.getEmail() == null || user.getEmail().trim().isEmpty() || user.getEmail().length() > 255) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty() || user.getFirstName().length() > 25)
            return false;
        if (user.getLastName() == null || user.getLastName().trim().isEmpty() || user.getLastName().length() > 25)
            return false;
<<<<<<< HEAD
        if (user.getHeroStatus() == null || user.getHeroStatus().trim().isEmpty() || user.getHeroStatus().equalsIgnoreCase("villian")
                || user.getHeroStatus().length() > 9)
            return false;
=======
        if (user.getCurrentStatus() == null || user.getCurrentStatus().trim().isEmpty() || user.getCurrentStatus().equals("villian"))
            return false;//need to work on this
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
        if (user.getDob() == null || user.getDob().trim().isEmpty() || user.getUsername().length() > 10) return false;

        return true;
    }

}




