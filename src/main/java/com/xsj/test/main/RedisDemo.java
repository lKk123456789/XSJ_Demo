package com.xsj.test.main;

import com.xsj.test.utils.RedisUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisDemo {
    @Test
    public void RedisDemoFun1Test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisUtils redisUtils= (RedisUtils) ac.getBean("redisUtil");
        redisUtils.set("name","xsj");
        Object name = redisUtils.get("name");
        System.out.println(name.toString());

    }
    @Test
    public void RedisDemoFun2Test(){
        Jedis jedis=new Jedis("localhost");
//        jedis.set("name", "xsj");
//        jedis.set("name2", "lkk");
//        jedis.select(1);
//        jedis.hvals("");
//        Set<String> keys = jedis.keys("*");
//        Iterator it=keys.iterator();
//        while(it.hasNext()){
//            String key= (String) it.next();
//            System.out.print(key+":");
//        }
//        jedis.lpush("list","list1");
//        jedis.lpush("list","list2");
//        jedis.lpush("list","list3");
        List<String> list = jedis.lrange("list", 0, 50);
        System.out.println(list);
    }
}
