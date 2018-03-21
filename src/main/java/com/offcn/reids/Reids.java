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
	
	
	//��map���ϴ洢����
	public Map<String,Reid> getMap(String keys){
			JedisPool pool=(JedisPool) app.getBean("jedisPool");
			Jedis jedis=pool.getResource();
			boolean iscache=jedis.exists("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes());
			if(!iscache){
				Test2.gettest2();
			}
			
			
			if(keys.equals("")){
				Map<String,Reid> map=(Map<String,Reid>) SerializationUtils.deserialize(jedis.get("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes()));
				jedis.close();
				return map;
			}else{
			Map<String,Reid> map=(Map<String,Reid>) SerializationUtils.deserialize(jedis.get("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes()));
			Set<String> set=map.keySet();
			
				Reid r=map.get(keys);
					r.setPoll(r.getPoll()+1);
					map.put(keys,r);
					Map<String,Reid> sortedMap=Test2.getsort(map);
				jedis.set("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes(), SerializationUtils.serialize(sortedMap));
			
			System.out.println("�ӻ�����ȡ");
			jedis.close();
			return map;
			}
	}
	
	
	//��set���ϴ洢����
	public Set<Reid> getSet(int keys){
		JedisPool pool=(JedisPool) app.getBean("jedisPool");
		Jedis jedis=pool.getResource();
		boolean iscache=jedis.exists("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes());
		if(!iscache){
			Test4.getReids();;
		}
		
		
		if(keys==0){
			Set<Reid> set=(Set<Reid>) SerializationUtils.deserialize(jedis.get("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes()));
			jedis.close();
			return set;
		}else{
			Set<Reid> set=(Set<Reid>) SerializationUtils.deserialize(jedis.get("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes()));
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
			jedis.set("�ž�ҵ-JAVA1016����ֵ��ѡ".getBytes(), SerializationUtils.serialize(set));
		
		System.out.println("�ӻ�����ȡ");
		jedis.close();
		return set;
		}
	}
	
}
