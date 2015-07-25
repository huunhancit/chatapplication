package com.tma.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.JList;
import javax.swing.JTabbedPane;

import com.tma.constant.Constant;
import com.tma.function.Function;
import com.tma.gui.TabPanel;
import com.tma.jms.ChatAPI;
import com.tma.jms.TopicConfigServer;

/**
 * 
 * @author dhnhan into chat group
 */
public class EventDoubleList implements MouseListener {
	private JList<String> listGroup;
	private JTabbedPane tab;
	private ChatAPI chatAPI;
	private String name;

	public EventDoubleList(JList<String> listGroup, JTabbedPane tab, String name) {
		this.listGroup = listGroup;
		this.tab = tab;
		this.name = name;
	}

	public JList<String> getListGroup() {
		return listGroup;
	}

	public void setListGroup(JList<String> listGroup) {
		this.listGroup = listGroup;
	}

	public JTabbedPane getTab() {
		return tab;
	}

	public void setTab(JTabbedPane tab) {
		this.tab = tab;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			String nameGroup = listGroup.getSelectedValue().toString();
			String nametopic = nameGroup.replaceAll("\\s+", "");
			if (!Function.checkTabExits(tab, nameGroup)) {
				try {
					TopicConfigServer.createTopicOnServer(nametopic);
					chatAPI = new ChatAPI(Constant.TYPE_DESTINATION + nametopic);
					TabPanel tab1 = new TabPanel(chatAPI, name, nameGroup);
					tab.addTab(nameGroup, tab1);
				} catch (NamingException | JMSException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
