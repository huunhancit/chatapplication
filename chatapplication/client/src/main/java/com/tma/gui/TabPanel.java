package com.tma.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.Set;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.tma.client.CallFunction;
import com.tma.event.EventSend;
import com.tma.jms.ChatAPI;
import com.tma.model.Message;
import com.tma.thread.MyThreadChat;

/**
 * component tab panel
 * 
 * @author dhnhan
 *
 */
public class TabPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnsend;
	private JTextArea content, enter;
	private JPanel p1;

	public TabPanel(ChatAPI chatAPI, String name, String namegroup) throws NamingException {
		this.btnsend = new JButton("Send");
		this.content = new JTextArea(10, 50);
		this.enter = new JTextArea(3, 43);
		p1 = new JPanel();
		this.p1.setLayout(new FlowLayout());
		this.p1.add(enter);
		this.p1.add(btnsend);
		this.setLayout(new BorderLayout());
		this.add(content, BorderLayout.NORTH);
		this.add(p1, BorderLayout.SOUTH);
		Set<Message> messages = CallFunction.getDataBean().getAllMessageByNameGroup(namegroup);
		Iterator iterator = messages.iterator();
		while (iterator.hasNext()){
			Message message = (Message) iterator.next();
			this.content.append(message.getContent() + "\t\t"+ message.getDate() + "\n");
		}
		new Thread(new MyThreadChat(content, chatAPI)).start();
		btnsend.addActionListener(new EventSend(enter, chatAPI, name, namegroup));
	}

}
