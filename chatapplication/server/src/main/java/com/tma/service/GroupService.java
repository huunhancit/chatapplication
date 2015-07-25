package com.tma.service;

import com.tma.model.Group;
import com.tma.model.Message;

import java.util.Set;

/**
 * Created by dhnhan on 7/2/15.
 */
public interface GroupService {
    public void addNewGroup(Group group);
    public Group findGroupName(String namegroup);
    public void addMessageIntoGroup(Group group,Message message);
    public boolean checkGroupExit(String namegroup);
    public Set<Message> getAllMessageByNameGroup(String namegroup);
    public void deleteMessageByNameGroup(String namegroud);
}
