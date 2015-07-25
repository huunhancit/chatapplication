package com.tma.event;

import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.tma.function.Function;

public class EventChangeTab implements ChangeListener {
	private JList<String> list;
	private JTabbedPane jTabbedPane;

	public EventChangeTab(JList<String> list, JTabbedPane jTabbedPane) {
		this.list = list;
		this.jTabbedPane = jTabbedPane;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}

	public void setjTabbedPane(JTabbedPane jTabbedPane) {
		this.jTabbedPane = jTabbedPane;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		String title = jTabbedPane.getTitleAt(jTabbedPane.getSelectedIndex());
		list.setSelectedIndex(Function.getIndexJlist(list, title));
	}
}
