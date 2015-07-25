package com.tma.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import com.tma.client.CallFunction;
import com.tma.function.Function;
import com.tma.model.Group;

/**
 * 
 * @author dhnhan
 * event create group on form chaat group
 */
public class EventCreateGroup implements ActionListener {
	private JTextField txtNameGroup;
	private DefaultListModel<String> model;

	public EventCreateGroup() {
	}

	public EventCreateGroup(JTextField txtNameGroup,
			DefaultListModel<String> model) {
		this.txtNameGroup = txtNameGroup;
		this.model = model;
	}

	public JTextField getTxtNameGroup() {
		return txtNameGroup;
	}

	public void setTxtNameGroup(JTextField txtNameGroup) {
		this.txtNameGroup = txtNameGroup;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String namegroup = txtNameGroup.getText().toString();
		if (!namegroup.equals("")) {
			if (!Function.checkListModelExits(model, namegroup)) {
				try {
					if (!CallFunction.getDataBean().checkGroupExit(namegroup)){
						CallFunction.getDataBean().addNewGroup(new Group(namegroup));
					}
					model.addElement(namegroup);
					txtNameGroup.setText("");
				} catch (NamingException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
