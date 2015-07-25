package com.tma.function;

import com.tma.model.User;

import javax.swing.*;
import java.util.List;


/**
 * function general
 * 
 * @author dhnhan
 *
 */
public class Function {
	/**
	 * / check item exits in model list
	 * 
	 * @param model
	 * @param item
	 * @return
	 * 
	 */
	public static boolean checkListModelExits(DefaultListModel<String> model,
			String item) {
		for (int i = 0; i < model.size(); i++) {
			if (model.get(i).equals(item)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check tab exits in tabpanel
	 * 
	 */
	public static boolean checkTabExits(JTabbedPane tab, String name) {
		for (int i = 0; i < tab.getTabCount(); i++) {
			if (tab.getTitleAt(i).equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param tab
	 * @param name
	 *            remove tab when user leave groups
	 */
	public static void removeTab(JTabbedPane tab, String name) {
		for (int i = 0; i < tab.getTabCount(); i++) {
			if (tab.getTitleAt(i).equals(name)) {
				tab.remove(i);
			}
		}
	}

	public static DefaultComboBoxModel<String> getListNameDataBase(
			List<User> users) {
		DefaultComboBoxModel<String> listName = new DefaultComboBoxModel<String>();
		for (User user: users) {
			listName.addElement(user.getUsername());
		}
		return listName;
	}

	/**
	 * get index of jlist
	 */
	public static int getIndexJlist(JList<String> jlist, String title) {
		for (int i = 0; i < jlist.getModel().getSize(); i++) {
			if (jlist.getModel().getElementAt(i).equals(title)) {
				return i;
			}
		}
		return 0;
	}
}
