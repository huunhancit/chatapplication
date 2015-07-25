package com.tma.thread;

import javax.jms.JMSException;
import javax.swing.JTextArea;

import com.tma.jms.ChatAPI;
/**
 * 
 * @author dhnhan
 * Thread for chat
 */
public class MyThreadChat implements Runnable {
	private JTextArea content;
	private ChatAPI api;

	public MyThreadChat(JTextArea content, ChatAPI api) {
		this.content = content;
		this.api = api;
	}

	public JTextArea getContent() {
		return content;
	}

	public void setContent(JTextArea content) {
		this.content = content;
	}

	public ChatAPI getApi() {
		return api;
	}

	public void setApi(ChatAPI api) {
		this.api = api;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (api != null) {
				try {
					content.append(api.receiveMessage() + "\n");
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
