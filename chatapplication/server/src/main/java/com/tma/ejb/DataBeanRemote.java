package com.tma.ejb;

import com.tma.model.Group;
import com.tma.model.Message;
import com.tma.model.User;

import javax.ejb.Remote;
import java.util.List;
import java.util.Set;

/**
 * Created by dhnhan on 7/2/15.
 */
@Remote
public interface DataBeanRemote {
    public void registerUser(User user);
    public boolean checkLogin(String username,String password);
    public boolean checkUserExits(String username);
    public void addNewGroup(Group group);
    public Group findGroupName(String namegroup);
    public void addMessageIntoGroup(Group group,Message message);
    public boolean checkGroupExit(String namegroup);
    public Set<Message> getAllMessageByNameGroup(String namegroup);
    public List<User> getAllUser();
    public void deleteMessageByNameGroup(String namegroud);
}
