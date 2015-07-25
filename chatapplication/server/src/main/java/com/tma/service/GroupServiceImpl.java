package com.tma.service;

import com.tma.dao.GroupDao;
import com.tma.model.Group;
import com.tma.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by dhnhan on 7/2/15.
 */
@Service(value = "groupService")
public class GroupServiceImpl implements GroupService{
    @Autowired
    @Qualifier(value = "groupDAO")
    GroupDao groupDao;

    @Override
    @Transactional
    public void addNewGroup(Group group) {
        groupDao.save(group);
    }

    @Override
    @Transactional
    public Group findGroupName(String namegroup) {
        return groupDao.findGroupByNameGroup(namegroup);
    }

    @Override
    @Transactional
    public void addMessageIntoGroup(Group group, Message message) {
        groupDao.addMessageIntoGroup(group,message);
    }

    @Override
    @Transactional
    public boolean checkGroupExit(String namegroup) {
        return groupDao.checkGroupExit(namegroup);
    }

    @Override
    @Transactional
    public Set<Message> getAllMessageByNameGroup(String namegroup) {
        return groupDao.getAllMessageByNameGroup(namegroup);
    }

    @Override
    public void deleteMessageByNameGroup(String namegroud) {
        groupDao.deleteMessageByNameGroup(namegroud);
    }
}
