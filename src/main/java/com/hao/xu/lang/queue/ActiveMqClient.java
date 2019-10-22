package com.hao.xu.lang.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 12:18 2019/3/9
 */
public class ActiveMqClient {


	private static final int SEND_NUMBER = 10;

	public static void main(String[] args) {

		//ConnectionFactory是连接工厂，JMS用它创建连接
		ConnectionFactory connectionFactory;
		//Connection JMS客户端到JMS provider的连接
		Connection connection = null;
		//Session 一个发送或者接收消息的线程
		Session session;
		//Destination 消息发送目的地，消息发送给谁接收
		Destination destination;
		//MessageProducer 消息发送者
		MessageProducer messageProducer;
		//构造ConnectionFactory 实例对象，此处采用ActiveMQ的实现jar
		connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://39.105.147.99:61616");

		try {
			//构造工厂得到连接对象
			connection = connectionFactory.createConnection();
			//启动
			connection.start();
			//获取操作连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			//创建一个Queue，名称为SongLiGuo_FirstQueue
			destination = session.createQueue("SongLiGuo_FirstQueue");
			//得到消息生产者【发送者】
			messageProducer = session.createProducer(destination);
			//设置不持久化，根据实际情况而定
			messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
			//构造消息，此处写死，项目就是参数或者方法获取
			sendMessage(session, messageProducer);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != connection){
					connection.close();
				}
			} catch (Throwable ignore) {
			}
		}
	}

	public static void sendMessage(Session session, MessageProducer producer)throws Exception {
		for (int i = 1; i <= SEND_NUMBER; i++) {
			TextMessage message = session.createTextMessage("hhhhhhhhh" + i);
			// 发送消息到目的地方
			System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
			producer.send(message);
		}
	}
}
