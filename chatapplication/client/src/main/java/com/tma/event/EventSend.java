package com.tma.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.JTextArea;

import com.tma.client.CallFunction;
import com.tma.jms.ChatAPI;
import com.tma.model.Group;
import com.tma.model.Message;

/**
 * event send message
 * 
 * @author dhnhan
 *
 */
public class EventSend implements ActionListener {
	private JTextArea enter;
	private ChatAPI chatAPI;
	private String name;
	private String namegroup;

	public EventSend() {
	}

	public EventSend(JTextArea enter, ChatAPI chatAPI, String name,
			String namegroup) {
		this.enter = enter;
		this.chatAPI = chatAPI;
		this.name = name;
		this.namegroup = namegroup;
	}

	public JTextArea getEnter() {
		return enter;
	}

	public void setEnter(JTextArea enter) {
		this.enter = enter;
	}

	public ChatAPI getChatAPI() {
		return chatAPI;
	}

	public void setChatAPI(ChatAPI chatAPI) {
		this.chatAPI = chatAPI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamegroup() {
		return namegroup;
	}

	public void setNamegroup(String namegroup) {
		this.namegroup = namegroup;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message = enter.getText().toString();
		if (!message.equals("")) {
			try {
				if (!CallFunction.getDataBean().checkGroupExit(namegroup)){
					CallFunction.getDataBean().addNewGroup(new Group(namegroup));
				}
				String msg = "[" + name + "]: " + message;
				chatAPI.sendMessage(msg);
				Group group = CallFunction.getDataBean().findGroupName(namegroup);
				CallFunction.getDataBean().addMessageIntoGroup(group,new Message(msg,new Date()));
				enter.setText("");
			} catch (JMSException e1) {
				e1.printStackTrace();
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
		}
	}

}
