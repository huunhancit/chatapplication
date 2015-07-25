package com.tma.thread;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.swing.DefaultListModel;

import com.tma.function.Function;
import com.tma.jms.ChatAPI;
/**
 * 
 * @author dhnhan
 * thread for invite
 */
public class MyThreadInvite implements Runnable {
	private ChatAPI chatAPI;
	private DefaultListModel<String> model;
	private String name;

	public MyThreadInvite(ChatAPI chatAPI, DefaultListModel<String> model,
			String name) {
		this.chatAPI = chatAPI;
		this.model = model;
		this.name = name;
	}

	public ChatAPI getChatAPI() {
		return chatAPI;
	}

	public void setChatAPI(ChatAPI chatAPI) {
		this.chatAPI = chatAPI;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				TextMessage message = chatAPI.receiveInvite();
				String nameUser = message.getStringProperty("name");
				String nameGroup = message.getStringProperty("group");
				if (nameUser.equals(name)) {
					if (!Function.checkListModelExits(model, nameGroup)) {
						model.addElement(nameGroup);
					}
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}

		}
	}

}
