package com.tma.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.tma.constant.Constant;
import com.tma.event.EventChangeTab;
import com.tma.event.EventCreateGroup;
import com.tma.event.EventDoubleList;
import com.tma.event.EventInvite;
import com.tma.event.EventLeaveGroup;
import com.tma.function.Function;
import com.tma.jms.ChatAPI;
import com.tma.thread.MyThreadInvite;

/**
 * @author dhnhan Grapphic User Interface chat
 */
public class ChatGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String NAMEGROUP = "Name Group: ";
	private static final String USER = "User: ";

	private JLabel labelNameGroup, labelUSer;
	private JButton btnCreateGroup, btnInvite, btnLeave,
			btndeletehisotry;
	private JTextField txtNameGroup;
	private JPanel pan1, p1, p2;
	private JList<String> listGroup;
	private DefaultListModel<String> model;
	private JComboBox<String> comInvite;
	private JTabbedPane tab;
	ChatAPI apiInvite;

	public ChatGUI() throws NamingException, JMSException {
		super("Chat Group (" + LoginGUI.user + ")");
		pan1 = new JPanel();
		model = new DefaultListModel<String>();
		listGroup = new JList<String>(model);
		listGroup.setBorder(BorderFactory.createTitledBorder("List Group"));
		listGroup.setPreferredSize(new Dimension(30, 100));
		JScrollPane jScrollPane = new JScrollPane(listGroup);
		jScrollPane.setPreferredSize(new Dimension(150, 300));
		// create group
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		labelNameGroup = new JLabel(NAMEGROUP);
		txtNameGroup = new JTextField(10);
		btnCreateGroup = new JButton("Create Group");
		btnLeave = new JButton("Leave");

		p1.add(labelNameGroup);
		p1.add(txtNameGroup);
		p1.add(btnCreateGroup);
		p1.add(btnLeave);
		// Invite
		labelUSer = new JLabel(USER);
		/**
		 * Load data from mysql to combobox
		 */
		comInvite = new JComboBox<String>(
				Function.getListNameDataBase(LoginGUI.beanRemote.getAllUser()));


		btndeletehisotry = new JButton("Delete History");
		btnInvite = new JButton("Invite");
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(labelUSer);
		p2.add(comInvite);
		p2.add(btnInvite);
		p2.add(btndeletehisotry);
		// tab chat

		tab = new JTabbedPane();
		JScrollPane jScrollPane2 = new JScrollPane(tab);
		jScrollPane2.setPreferredSize(new Dimension(200, 240));
		pan1.setLayout(new BorderLayout());
		pan1.add(p1, BorderLayout.NORTH);
		pan1.add(p2, BorderLayout.CENTER);
		pan1.add(jScrollPane2, BorderLayout.SOUTH);
		pan1.setPreferredSize(new Dimension(650, 310));

		this.setLayout(new FlowLayout());
		this.add(jScrollPane);
		this.add(pan1);
		this.setSize(850, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		apiInvite = new ChatAPI(Constant.TYPE_DESTINATION + "invite");
		new Thread(new MyThreadInvite(apiInvite, model, LoginGUI.user)).start();
		// event button
		this.btnCreateGroup.addActionListener(new EventCreateGroup(
				txtNameGroup, model));
		this.btnLeave.addActionListener(new EventLeaveGroup(model, listGroup,
				tab));
		this.btnInvite.addActionListener(new EventInvite(listGroup, comInvite,
				apiInvite));
		this.listGroup.addMouseListener(new EventDoubleList(listGroup, tab,
				LoginGUI.user));
		this.tab.addChangeListener(new EventChangeTab(listGroup, tab));

	}

	public static void main(String[] args) throws NamingException, JMSException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ChatGUI chatGUI;
				try {
					chatGUI = new ChatGUI();
					chatGUI.setVisible(true);
				} catch (NamingException | JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
