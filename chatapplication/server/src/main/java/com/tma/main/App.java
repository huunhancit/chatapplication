package com.tma.main;

import com.tma.dao.GroupDao;
import com.tma.dao.UserDao;
import com.tma.model.Group;
import com.tma.model.Message;
import com.tma.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Iterator;


/**
 * Created by dhnhan on 7/2/15.
 */
public class App {
    public static void main(String arg[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDAO");
        GroupDao groupDao = (GroupDao) context.getBean("groupDAO");
//        groupDao.save(new Group("nhau dy"));
//        Group group = groupDao.findGroupByNameGroup("nhau dy");
//        groupDao.addMessageIntoGroup(group,new Message("hello all",new Date()));
//        groupDao.addMessageIntoGroup(group,new Message("hi all",new Date()));
//        Iterator iterator = group.getMessages().iterator();
//        while (iterator.hasNext()){
//            Message message = (Message) iterator.next();
//            System.out.println(message.getContent());
//        }
        userDao.save(new User("nhan","nhan","nhan@tma.com.vn"));
//        groupDao.addMessageIntoGroup(groupDao.findGroupByNameGroup("a"),new Message("hello", new Date()));
    }
}
