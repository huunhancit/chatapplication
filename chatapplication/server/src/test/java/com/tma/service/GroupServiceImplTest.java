//package com.tma.service;
//
//import com.tma.model.Group;
//import com.tma.model.Message;
//import junit.framework.TestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.Iterator;
//
///**
// * Created by dhnhan on 7/3/15.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:appContext.xml"})
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
//public class GroupServiceImplTest extends TestCase {
//    @Autowired
//    GroupService groupService;
//
//    @Test
//    public void testAddNewGroup() throws Exception {
//        Group groupExcepted = new Group("hello");
//        groupService.addNewGroup(groupExcepted);
//        assertEquals(groupExcepted.getNamegroup(),groupService.findGroupName("hello").getNamegroup());
//    }
//    @Test
//    public void testFindGroupName() throws Exception {
//        String namegroupExcepted = "hello";
//        Group group = groupService.findGroupName(namegroupExcepted);
//        assertEquals(namegroupExcepted,group.getNamegroup());
//    }
//    @Test
//    public void testAddMessageIntoGroup() throws Exception {
//        Message messageExcepted = new Message("hi all", new Date());
//        Group group = groupService.findGroupName("hello");
//        groupService.addMessageIntoGroup(group,messageExcepted);
//        Iterator iterator = groupService.findGroupName("hello").getMessages().iterator();
//        Message message = null;
//        while (iterator.hasNext()){
//            message = (Message) iterator.next();
//        }
//        assertEquals(messageExcepted.getContent(),message.getContent());
//    }
//    @Test
//    public void testCheckGroupExit() throws Exception {
//        // group exits
//        String namegroupExitsExcepted = "hello";
//        assertTrue(groupService.checkGroupExit(namegroupExitsExcepted));
//        // group not exits
//        String namegroupNotExitsExcepted = "hello1";
//        assertFalse(groupService.checkGroupExit(namegroupNotExitsExcepted));
//
//    }
//    @Test
//    public void testGetAllMessageByNameGroup() throws Exception {
//        int numberMessageExcepted = 1;
//        int numberMessageActual = 0;
//        Iterator iterator = groupService.getAllMessageByNameGroup("hello").iterator();
//        while (iterator.hasNext()){
//            Message message = (Message) iterator.next();
//            numberMessageActual = numberMessageActual + 1;
//        }
//        assertEquals(numberMessageActual-1,numberMessageExcepted);
//    }
//
//    public void testDeleteMessageByNameGroup() throws Exception {
//
//    }
//}