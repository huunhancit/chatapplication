package com.tma.jms;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tma.constant.Constant;
/**
 * api chat: 
 * 		+ send message
 * 		+ recevie message
 * @author dhnhan
 *
 */
public class ChatAPI {
	private TopicConnectionFactory topicConnectFactory;
	private TopicConnection topicConnect;
	private TopicSession topicSessionPu, topicSessionSu;
	private Topic topic;
	private TopicPublisher topicPublisher;
	private TopicSubscriber topicSubscriber;

	public TopicConnectionFactory getTopicConnectFactory() {
		return topicConnectFactory;
	}

	public void setTopicConnectFactory(
			TopicConnectionFactory topicConnectFactory) {
		this.topicConnectFactory = topicConnectFactory;
	}

	public TopicConnection getTopicConnect() {
		return topicConnect;
	}

	public void setTopicConnect(TopicConnection topicConnect) {
		this.topicConnect = topicConnect;
	}

	public TopicSession getTopicSessionPu() {
		return topicSessionPu;
	}

	public void setTopicSessionPu(TopicSession topicSessionPu) {
		this.topicSessionPu = topicSessionPu;
	}

	public TopicSession getTopicSessionSu() {
		return topicSessionSu;
	}

	public void setTopicSessionSu(TopicSession topicSessionSu) {
		this.topicSessionSu = topicSessionSu;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public TopicPublisher getTopicPublisher() {
		return topicPublisher;
	}

	public void setTopicPublisher(TopicPublisher topicPublisher) {
		this.topicPublisher = topicPublisher;
	}

	public TopicSubscriber getTopicSubscriber() {
		return topicSubscriber;
	}

	public void setTopicSubscriber(TopicSubscriber topicSubscriber) {
		this.topicSubscriber = topicSubscriber;
	}

	public ChatAPI(String jms) throws NamingException, JMSException {
		initialContext();
		this.topicConnectFactory = (TopicConnectionFactory) initialContext()
				.lookup(Constant.JMS_REMOTE_FACTORY);
		this.topic = (Topic) initialContext().lookup(jms);
		this.topicConnect = this.topicConnectFactory.createTopicConnection(
				Constant.SECURITY_USER, Constant.SECURIY_PASS);
		this.topicConnect.start();
		this.topicSessionPu = this.topicConnect.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);
		this.topicSessionSu = this.topicConnect.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);
		this.topicPublisher = this.topicSessionPu.createPublisher(topic);
		this.topicSubscriber = this.topicSessionSu.createSubscriber(topic);
	}

	// receive message
	public String receiveMessage() throws JMSException {
		TextMessage txt = (TextMessage) this.topicSubscriber.receive();
		return txt.getText().toString();
	}

	// send message
	public void sendMessage(String msg) throws JMSException {
		TextMessage txt = this.topicSessionPu.createTextMessage();
		txt.setText(msg);
		topicPublisher.send(txt);
	}

	public void inviteMesage(String name, String group) throws JMSException {
		TextMessage txt = this.topicSessionPu.createTextMessage();
		txt.setStringProperty("name", name);
		txt.setStringProperty("group", group);
		topicPublisher.send(txt);
	}

	public TextMessage receiveInvite() throws JMSException {
		return (TextMessage) this.topicSubscriber.receive();
	}

	public void closeCon() throws JMSException {
		this.topicConnect.close();
	}

	private static InitialContext initialContext() throws NamingException {
		Properties properties = new Properties();
		properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				Constant.CONTEXT_FACTORY);
		properties.setProperty(Context.PROVIDER_URL, Constant.URL_REMOTE);
		properties.put(Constant.NAMING_CLIENT, true);
		properties.put(Context.SECURITY_PRINCIPAL, Constant.SECURITY_USER);
		properties.put(Context.SECURITY_CREDENTIALS, Constant.SECURIY_PASS);
		return new InitialContext(properties);
	}
}
