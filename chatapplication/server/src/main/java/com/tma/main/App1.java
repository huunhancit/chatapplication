package com.tma.main;

import com.tma.ejb.DataBeanRemote;
import com.tma.model.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by dhnhan on 7/2/15.
 */
public class App1 {
    public static DataBeanRemote getDataBean() throws NamingException {
        InitialContext ic = new InitialContext();
        return (DataBeanRemote) ic.lookup("com.tma.ejb.DataBeanRemote");
    }
    public static void main(String arg[]) throws NamingException {
        App1.getDataBean().registerUser(new User("nhan","nhan","nhan@tma.com.vn"));
//            System.out.println(App1.getDataBean().checkLogin("nhasn","nhan"));
    }

}
