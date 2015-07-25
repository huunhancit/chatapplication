package com.tma.ejb;

import com.tma.model.Group;
import com.tma.model.Message;
import com.tma.model.User;
import com.tma.service.GroupService;
import com.tma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import java.util.List;
import java.util.Set;

/**
 * Created by dhnhan on 7/2/15.
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class DataBean implements DataBeanRemote{

    @Autowired
    @Qualifier(value = "groupService")
    GroupService groupService;
    @Autowired
    @Qualifier(value = "userService")
    UserService userService;

    @Override
    public void registerUser(User user) {
        userService.save(user);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return userService.checkLogin(username,password);
    }

    @Override
    public boolean checkUserExits(String username) {
        return userService.checkUserExits(username);
    }

    @Override
    public void addNewGroup(Group group) {
        groupService.addNewGroup(group);
    }

    @Override
    public Group findGroupName(String namegroup) {
        return groupService.findGroupName(namegroup);
    }

    @Override
    public void addMessageIntoGroup(Group group, Message message) {
        groupService.addMessageIntoGroup(group,message);
    }

    @Override
    public boolean checkGroupExit(String namegroup) {
        return groupService.checkGroupExit(namegroup);
    }

    @Override
    public Set<Message> getAllMessageByNameGroup(String namegroup) {
        return groupService.getAllMessageByNameGroup(namegroup);
    }

    @Override
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @Override
    public void deleteMessageByNameGroup(String namegroud) {
        groupService.deleteMessageByNameGroup(namegroud);
    }
}
