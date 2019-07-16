package com.Ian.trillio.Dao;

import com.Ian.trillio.general.DataStore;
import com.Ian.trillio.entities.User;

import java.util.List;

public class UserDao {
    public List<User> getUsers() {
        return DataStore.getUsers();
    }
}
