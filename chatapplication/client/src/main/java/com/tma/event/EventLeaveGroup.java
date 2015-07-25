package com.tma.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTabbedPane;

import com.tma.function.Function;

/**
 * ]
 *
 * @author dhnhan event leave chat group
 */
public class EventLeaveGroup implements ActionListener {
	private DefaultListModel<String> model;
	private JList<String> list;
	private JTabbedPane tab;

	public EventLeaveGroup(DefaultListModel<String> model, JList<String> list,
			JTabbedPane tab) {
		this.model = model;
		this.list = list;
		this.tab = tab;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public JTabbedPane getTab() {
		return tab;
	}

	public void setTab(JTabbedPane tab) {
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = list.getSelectedIndex();
		String namegroup = list.getSelectedValue().toString();
		model.remove(index);
		Function.removeTab(tab, namegroup);
	}
}
