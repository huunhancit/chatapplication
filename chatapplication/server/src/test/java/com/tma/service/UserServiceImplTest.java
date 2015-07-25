//package com.tma.service;
//
//import com.tma.model.User;
//import junit.framework.TestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by dhnhan on 7/3/15.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:appContext.xml"})
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
//public class UserServiceImplTest extends TestCase {
//
//    @Autowired
//    UserService userService;
//
//    @Test
//    @Rollback(value = true)
//    @Transactional
//    public void testSave() throws Exception {
//        User userExpected = new User("dung","dung","dung@tma.com.vn");
//        userService.save(userExpected);
//        User userActual = userService.getUserByName("dung");
//        assertEquals(userExpected.getUsername(),userActual.getUsername());
//        assertEquals(userExpected.getPassword(),userActual.getPassword());
//    }
//    @Test
//    public void testCheckLogin() throws Exception {
//
//        // login sucessful
//        String usernameExpected = "nhan";
//        String passwordExpected = "nhan";
//        assertTrue(userService.checkLogin(usernameExpected,passwordExpected));
//        // login fail
//        String usernameExpectedFail = "nhan1";
//        String passwordExpectedFail = "nnhan1";
//        assertFalse(userService.checkLogin(usernameExpectedFail,passwordExpectedFail));
//
//    }
//    @Test
//    public void testCheckUserExits() throws Exception {
//        // user exits
//        String username ="nhan";
//        assertTrue(userService.checkUserExits(username));
//        // user not exits
//        String usernameNotExits = "nam";
//        assertFalse(userService.checkUserExits(usernameNotExits));
//    }
//    @Test
//    public void testGetAllUser() throws Exception {
//        int numberUserExcepted = 2;
//        int numberUserActual = userService.getAllUser().size();
//        assertEquals(numberUserExcepted,numberUserActual);
//    }
//}