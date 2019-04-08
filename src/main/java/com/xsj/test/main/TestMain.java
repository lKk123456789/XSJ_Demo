package com.xsj.test.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args){
//        JsmDemo2 jsmDemo2 = new JsmDemo2();
//        Thread thread=new Thread(new JmsDemo(),"T0");
//        Thread thread2=new Thread(jsmDemo2, "T1");
//        Thread thread3=new Thread(jsmDemo2,"T2");
//        thread.start();
//        thread2.start();
//        thread3.start();
       ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        QueueProducer queueProducer= (QueueProducer) ac.getBean("queueProducer");
        queueProducer.SendMessage("123");



    }
}
