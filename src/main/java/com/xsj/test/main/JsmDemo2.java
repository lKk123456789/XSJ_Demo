package com.xsj.test.main;

import com.xsj.test.utils.JmsUtils;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

class JsmDemo2 implements Runnable {

    public void run() {

                try {
                    Connection connection = null;
                    connection = new JmsUtils().GetConnect();
                    connection.start();
                    Session session = null;
                    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                    Queue queue = null;
                    queue = session.createQueue("test-queue");
                    MessageConsumer consumer = null;
                    consumer = session.createConsumer(queue);
                   final String name = Thread.currentThread().getName();
                    consumer.setMessageListener(new MessageListener() {
                        public void onMessage(Message message) {
                            TextMessage textMessage = (TextMessage) message;
                            try {
                                System.out.println(textMessage.getText() + "----->" + name);
                            } catch (JMSException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    System.in.read();
                    new JmsUtils().JmsClose(session, connection, consumer);
                    Thread.sleep(200);
                } catch (JMSException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }
        /*
            AUTO_ACKNOWLEDGE = 1 自动确认
             CLIENT_ACKNOWLEDGE = 2 客户端手动确认
             DUPS_OK_ACKNOWLEDGE = 3 自动批量确认
             SESSION_TRANSACTED = 0 事务提交并确认
         */

}
