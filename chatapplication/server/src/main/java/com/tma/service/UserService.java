package com.tma.service;

import com.tma.model.User;

import java.util.List;

/**
 * Created by dhnhan on 7/2/15.
 */
public interface UserService {
    public void save (User user);
    public boolean checkLogin(String username,String password);
    public boolean checkUserExits(String username);
    public List<User> getAllUser();
    public User getUserByName(String username);

}
