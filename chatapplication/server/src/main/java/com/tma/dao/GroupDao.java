package com.tma.dao;

import com.tma.model.Group;
import com.tma.model.Message;

import java.util.Set;

/**
 * Created by dhnhan on 7/2/15.
 */
public interface GroupDao extends Dao {
    public Group findGroupByNameGroup(String namegroup);
    public void addMessageIntoGroup(Group group, Message message);
    public Set<Message> getAllMessageByNameGroup (String namegroup);
    public boolean checkGroupExit(String namegroup);
    public void deleteMessageByNameGroup(String namegroud);
}
