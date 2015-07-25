package com.tma.dao;

import com.tma.model.User;

import java.util.List;

/**
 * Created by dhnhan on 7/2/15.
 */
public interface UserDao extends Dao {
    public boolean checkLogin(String username, String password);
    public User getUserByName(String name);
    public boolean checkUserExist(String username);
    public List<User> getAllUser();
}
