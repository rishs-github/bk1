package com.hp.bsc.testing.jmssender;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.hp.bsc.testing.jmssender.config.QueueEnvironmentConfig;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnectionFactory;

public class WmqSender {

	public static void send(QueueEnvironmentConfig config, String message) throws JMSException {

		MQQueueConnectionFactory queueConnectionFactory = new MQQueueConnectionFactory();
		queueConnectionFactory.setTransportType(1);
		queueConnectionFactory.setHostName(config.getWmqHost());
		queueConnectionFactory.setPort(config.getWmqPort());
		queueConnectionFactory.setQueueManager(config.getWmqManagerName());
		queueConnectionFactory.setChannel(config.getWmqChannel());

		QueueConnection connection = queueConnectionFactory.createQueueConnection();
		connection.start();
		try {
			Queue queue = new MQQueue(config.getJndiName());
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			TextMessage textMessage = session.createTextMessage(message);

			sender.send(textMessage);

		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
