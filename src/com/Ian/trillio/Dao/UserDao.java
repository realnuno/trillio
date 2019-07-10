package com.Ian.trillio.Dao;

import com.Ian.trillio.DataStore;
import com.Ian.trillio.entities.User;

public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
