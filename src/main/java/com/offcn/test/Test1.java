package com.offcn.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test1 {

	

	public void gettest(){
		Jedis jedis = new Jedis("10.10.12.134",6379);
		String str=jedis.get("a2");
		jedis.set("mytest", "hello word!");
		System.out.println(str);
	}
	

	public void getpool(){
		JedisPool jedisPool = new JedisPool("10.10.12.134",6379);
		Jedis resource = jedisPool.getResource();
		System.out.println(resource.get("mytest"));
		System.out.println(resource.hgetAll("user"));
	}
}
