package com.tma.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jms.JMSException;
import javax.swing.JComboBox;
import javax.swing.JList;

import com.tma.jms.ChatAPI;
/**
 * 
 * @author dhnhan
 * event button invite user
 */
public class EventInvite implements ActionListener {
	private JList<String> listGroup;
	private JComboBox<String> userDestination;
	private ChatAPI api;

	public EventInvite(JList<String> listGroup,
			JComboBox<String> userDestination, ChatAPI api) {
		this.listGroup = listGroup;
		this.userDestination = userDestination;
		this.api = api;
	}

	public JList<String> getListGroup() {
		return listGroup;
	}

	public void setListGroup(JList<String> listGroup) {
		this.listGroup = listGroup;
	}

	public JComboBox<String> getUserDestination() {
		return userDestination;
	}

	public void setUserDestination(JComboBox<String> userDestination) {
		this.userDestination = userDestination;
	}

	public ChatAPI getApi() {
		return api;
	}

	public void setApi(ChatAPI api) {
		this.api = api;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String namegroup = listGroup.getSelectedValue().toString();
		String user = userDestination.getSelectedItem().toString();
		if (!namegroup.equals("") || !user.equals("")) {
			try {
				api.inviteMesage(user, namegroup);
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}
	}
}
