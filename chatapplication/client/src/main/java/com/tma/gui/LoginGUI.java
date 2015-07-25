package com.tma.gui;

import com.tma.client.CallFunction;
import com.tma.ejb.DataBeanRemote;
import com.tma.event.EventRegister;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * form login 
 * @author dhnhan
 *
 */
public class LoginGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String strTitle = "Login";
	private static final String labelSignUp = "Sign Up";
	private static final String labelName = "Name: ";
	private static final String labelPass = "Password: ";
	private static final String labelEnter = "Enter";
	private static final String labelRegister = "Register";

	private JLabel name, password, title;
	private JButton btnenter, btnregister;
	private JPasswordField txtpass;
	private JTextField txtname;
	private JPanel pan1, pan2;
	public static String user;
	public static DataBeanRemote beanRemote;

	public LoginGUI() throws NamingException {
		super(strTitle);
		title = new JLabel(labelSignUp);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		this.pan1 = new JPanel();
		this.pan1.setLayout(new GridLayout(4, 1));
		this.name = new JLabel(labelName);
		this.txtname = new JTextField(15);
		this.password = new JLabel(labelPass);
		this.txtpass = new JPasswordField(15);
		this.pan1.add(name);
		this.pan1.add(txtname);
		this.pan1.add(password);
		this.pan1.add(txtpass);
		this.pan2 = new JPanel();
		this.pan2.setLayout(new FlowLayout());
		this.btnenter = new JButton(labelEnter);
		this.btnregister = new JButton(labelRegister);
		this.pan2.add(btnenter);
		this.pan2.add(btnregister);
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		// event button
		this.btnenter.addActionListener(new EventLogin());
		this.btnregister.addActionListener(new EventRegister());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		beanRemote = CallFunction.getDataBean();
		this.pack();
	}

	public static void main(String[] args) throws NamingException {
		LoginGUI gui = new LoginGUI();
		gui.setVisible(true);
	}

	/**
	 * 
	 * @author dhnhan
	 * class event login 
	 * if login success show form chat 
	 * else show message login fail 
	 */
	class EventLogin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = txtname.getText().toString();
			@SuppressWarnings("deprecation")
			String pass = txtpass.getText().toString();
			try {
				if (beanRemote.checkLogin(name, pass)) {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Login successful !");
					user = name;
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							try {
								new ChatGUI().setVisible(true);
								setVisible(false);
							} catch (NamingException | JMSException e) {
								e.printStackTrace();
							}

						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "Login fail !");
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			}
		}

	}
}
