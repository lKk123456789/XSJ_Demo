package com.xsj.test.main;

import com.xsj.test.utils.JmsUtils;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class JmsDemo implements Runnable{

    public void run() {

        try {
            Connection connection=null;
            connection = new JmsUtils().GetConnect();
            connection.start();
            Session session = null;
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = null;
            queue = session.createQueue("test-queue");
            MessageProducer producer = null;
            producer = session.createProducer(queue);
            TextMessage textMessage = null;
            for (int i = 0; i <1000 ; i++) {
                textMessage = session.createTextMessage("Message"+i+"From"+Thread.currentThread().getName());
                producer.send(textMessage);
            }
            new JmsUtils().JmsClose(session, connection,producer);
        } catch (JMSException e) {
            e.printStackTrace();
        }




        }
    }
