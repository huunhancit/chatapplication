package com.tma.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tma.event.EventCancel;
import com.tma.event.EventRegisterData;
/**
 * form register
 * @author dhnhan
 *
 */
public class RegisterGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel name, password, email, title;
	private JTextField txtname, txtemail;
	private JPasswordField txtpass;
	private JButton btnregister, btncancel;
	private JPanel pan1, pan2;

	public RegisterGUI() {
		super("Register");
		title = new JLabel("Sign up");
		title.setFont(new Font("Serif", Font.BOLD, 20));
		this.pan1 = new JPanel();
		this.pan1.setLayout(new GridLayout(6, 1));
		name = new JLabel("Name: ");
		txtname = new JTextField(20);
		password = new JLabel("Password: ");
		txtpass = new JPasswordField(20);
		email = new JLabel("Email: ");
		txtemail = new JTextField(20);
		this.pan1.add(name);
		pan1.add(txtname);
		pan1.add(password);
		pan1.add(txtpass);
		pan1.add(email);
		pan1.add(txtemail);
		this.pan2 = new JPanel();
		this.pan2.setLayout(new FlowLayout());
		btnregister = new JButton("Register");
		btncancel = new JButton("Cancel");
		this.pan2.add(btnregister);
		this.pan2.add(btncancel);

		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// event button
		this.btncancel.addActionListener(new EventCancel(this));
		this.btnregister.addActionListener(new EventRegisterData(txtname,
				txtpass, txtemail));
		this.pack();
	}
}
