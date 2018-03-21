package com.offcn.reids;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SerializationUtils;

import com.offcn.entity.Reid;
import com.offcn.test.Test2;
import com.offcn.test.Test4;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Reids {

	ApplicationContext app=new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
	
	
	//用map集合存储数据
	public Map<String,Reid> getMap(String keys){
			JedisPool pool=(JedisPool) app.getBean("jedisPool");
			Jedis jedis=pool.getResource();
			boolean iscache=jedis.exists("优就业-JAVA1016班颜值评选".getBytes());
			if(!iscache){
				Test2.gettest2();
			}
			
			
			if(keys.equals("")){
				Map<String,Reid> map=(Map<String,Reid>) SerializationUtils.deserialize(jedis.get("优就业-JAVA1016班颜值评选".getBytes()));
				jedis.close();
				return map;
			}else{
			Map<String,Reid> map=(Map<String,Reid>) SerializationUtils.deserialize(jedis.get("优就业-JAVA1016班颜值评选".getBytes()));
			Set<String> set=map.keySet();
			
				Reid r=map.get(keys);
					r.setPoll(r.getPoll()+1);
					map.put(keys,r);
					Map<String,Reid> sortedMap=Test2.getsort(map);
				jedis.set("优就业-JAVA1016班颜值评选".getBytes(), SerializationUtils.serialize(sortedMap));
			
			System.out.println("从缓存中取");
			jedis.close();
			return map;
			}
	}
	
	
	//用set集合存储数据
	public Set<Reid> getSet(int keys){
		JedisPool pool=(JedisPool) app.getBean("jedisPool");
		Jedis jedis=pool.getResource();
		boolean iscache=jedis.exists("优就业-JAVA1016班颜值评选".getBytes());
		if(!iscache){
			Test4.getReids();;
		}
		
		
		if(keys==0){
			Set<Reid> set=(Set<Reid>) SerializationUtils.deserialize(jedis.get("优就业-JAVA1016班颜值评选".getBytes()));
			jedis.close();
			return set;
		}else{
			Set<Reid> set=(Set<Reid>) SerializationUtils.deserialize(jedis.get("优就业-JAVA1016班颜值评选".getBytes()));
			Iterator<Reid> it=set.iterator();
			while(it.hasNext()){
				Reid reid=it.next();
				if(reid.getId()==keys){
					set.remove(reid);
					reid.setPoll(reid.getPoll()+1);
					set.add(reid);
					break;
				}
			}
			jedis.set("优就业-JAVA1016班颜值评选".getBytes(), SerializationUtils.serialize(set));
		
		System.out.println("从缓存中取");
		jedis.close();
		return set;
		}
	}
	
}
