package com.tma.client;
import com.tma.ejb.DataBeanRemote;
import com.tma.model.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;



/**
 * 
 * @author dhnhan
 * call function form server bean 
 */
public class CallFunction {
	public static DataBeanRemote getDataBean() throws NamingException {
		InitialContext ic = new InitialContext();
		return (DataBeanRemote) ic.lookup("com.tma.ejb.DataBeanRemote");
	}
	public static  void main(String arg[]) throws NamingException {
		CallFunction.getDataBean().registerUser(new User("nhan","nhan","nhan@tma.com.vn"));
	}
}
