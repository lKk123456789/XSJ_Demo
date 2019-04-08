package com.xsj.test.main;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class QueueProducer {
    private JmsTemplate jmsTemplate;
    private Destination queueTextSedtination;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setQueueTextSedtination(Destination queueTextSedtination) {
        this.queueTextSedtination = queueTextSedtination;
    }

    public void SendMessage(final String text){
        jmsTemplate.send(queueTextSedtination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }
}
