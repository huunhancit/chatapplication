package com.tma.event;



import com.tma.client.CallFunction;

import javax.naming.NamingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dhnhan on 7/2/15.
 */
public class EventDeleteHistory implements ActionListener {
    private JList<String> listgroup;
    public EventDeleteHistory(JList<String> listgroup) {
        this.listgroup = listgroup;
    }

    public JList<String> getListgroup() {
        return listgroup;
    }

    public void setListgroup(JList<String> listgroup) {
        this.listgroup = listgroup;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String namegroup = listgroup.getSelectedValue().toString();
        if (!namegroup.equals(""))
            try {
                CallFunction.getDataBean().deleteMessageByNameGroup(namegroup);
            } catch (NamingException e) {
                e.printStackTrace();
            }
    }
}
