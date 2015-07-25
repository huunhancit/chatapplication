package com.tma.jms;

import java.io.IOException;
import java.net.InetAddress;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;

import com.tma.constant.Constant;
/**
 * add and remove topic dynamic on server jboss
 * @author dhnhan
 *
 */
public class TopicConfigServer {

	public static boolean createTopicOnServer(String newtopic)
			throws IOException {
		ModelControllerClient client = null;
		ModelNode op = new ModelNode();
		ModelNode address = op.get(ClientConstants.OP_ADDR);
		address.add("subsystem", "messaging");
		address.add("hornetq-server", "default");
		// the name of the topic
		address.add(Constant.JMS_TOPIC, newtopic);
		// the JNDI entries
		ModelNode entries = op.get("entries");
		entries.add(Constant.TYPE_DESTINATION + newtopic);
		entries.add(Constant.JNDI_TOPIC + newtopic);
		op.get(ClientConstants.OP).set(ClientConstants.ADD);
		boolean res;
		try {
			client = ModelControllerClient.Factory.create(
					InetAddress.getByName(Constant.HOST_NAME), 9999);
			ModelNode result = client.execute(op);
			res = result.asBoolean();
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {

				}
			}
		}
		return res;
	}

	public static boolean removeTopicOnServer(String oldtopic)
			throws IOException {
		String destinationType = Constant.JMS_TOPIC;
		ModelControllerClient client = null;
		ModelNode removeJmsQueue = new ModelNode();
		removeJmsQueue.get(ClientConstants.OP).set("remove");
		removeJmsQueue.get(ClientConstants.OP_ADDR).add("subsystem",
				"messaging");
		removeJmsQueue.get(ClientConstants.OP_ADDR).add("hornetq-server",
				"default");
		removeJmsQueue.get(ClientConstants.OP_ADDR).add(destinationType,
				oldtopic);
		client = ModelControllerClient.Factory.create(
				InetAddress.getByName(Constant.HOST_NAME), 9999);
		boolean result = client.execute(removeJmsQueue).asBoolean();
		client.close();
		return result;
	}

	public static void main(String[] args) throws IOException {
		TopicConfigServer.createTopicOnServer("invite");
	}
}
