package com.Ian.trillio.managers;

import com.Ian.trillio.Dao.UserDao;
import com.Ian.trillio.entities.User;

import java.util.List;

public class UserManager {
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();

    private UserManager() {}

    public static UserManager getInstance() {
        return instance;
    }

    public User createUser(long id, String email, String passWord, String firstName, String lastName, int gender, String userType) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassWord(passWord);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUserType(userType);

        return user;
    }

    public List<User> getUsers() {
        return dao.getUsers();
    }
}
