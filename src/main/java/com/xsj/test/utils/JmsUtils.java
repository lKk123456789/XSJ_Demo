package com.xsj.test.utils;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsUtils {
    public Connection GetConnect() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = null;
        connection = connectionFactory.createConnection();
        return connection;
    }
    public void JmsClose(Session session, Connection connection, MessageConsumer consumer) throws JMSException {
        consumer.close();
        session.close();
        connection.close();
    }
    public void JmsClose(Session session, Connection connection, MessageProducer producer) throws JMSException {
        producer.close();
        session.close();
        connection.close();
    }
}
