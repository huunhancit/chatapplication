package com.tma.service;

import com.tma.dao.UserDao;
import com.tma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by dhnhan on 7/2/15.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDAO")
    UserDao userDao;
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public boolean checkLogin(String username, String password) {
        return userDao.checkLogin(username,password);
    }

    @Override
    @Transactional
    public boolean checkUserExits(String username) {
        return userDao.checkUserExist(username);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
