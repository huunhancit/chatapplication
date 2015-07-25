package com.tma.event;

import com.tma.client.CallFunction;
import com.tma.model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * add user into database
 * @author dhnhan
 *
 */
public class EventRegisterData implements ActionListener {
	private JTextField txtname;
	private JPasswordField txtpass;
	private JTextField txtmail;

	public EventRegisterData() {
	}

	public EventRegisterData(JTextField txtname, JPasswordField txtpass,
			JTextField txtmail) {
		this.txtname = txtname;
		this.txtpass = txtpass;
		this.txtmail = txtmail;
	}

	public JTextField getTxtname() {
		return txtname;
	}

	public void setTxtname(JTextField txtname) {
		this.txtname = txtname;
	}

	public JPasswordField getTxtpass() {
		return txtpass;
	}

	public void setTxtpass(JPasswordField txtpass) {
		this.txtpass = txtpass;
	}

	public JTextField getTxtmail() {
		return txtmail;
	}

	public void setTxtmail(JTextField txtmail) {
		this.txtmail = txtmail;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = txtname.getText().toString().trim();
		String pass = txtpass.getText().toString().trim();
		String mail = txtmail.getText().toString().trim();
		User user = new User(name,pass,mail);
		try {
			if (!CallFunction.getDataBean().checkUserExits(name)){
				CallFunction.getDataBean().registerUser(user);
				JOptionPane.showMessageDialog(null, "Register sucessful !");
				txtname.setText("");
				txtpass.setText("");
				txtmail.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null,"User exits !");
			}
		} catch (NamingException e1) {
			JOptionPane.showMessageDialog(null, "Register fail !");
		}
	}

}
