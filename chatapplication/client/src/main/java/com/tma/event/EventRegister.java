package com.tma.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tma.gui.RegisterGUI;
/**
 * show form register
 * @author dhnhan
 *
 */
public class EventRegister implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		RegisterGUI gui = new RegisterGUI();
		gui.setVisible(true);
	}

}
