package com.offcn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SerializationUtils;

import com.offcn.entity.Reid;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test2 {
	static ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
	
	@SuppressWarnings("unchecked")
	public static void gettest2(){
		JedisPool pool=(JedisPool) context.getBean("jedisPool");
		Jedis resource = pool.getResource();
		Map<String,Reid> map=new TreeMap<>();
		String[] str={"冯荣新","郝峰磊","菅保乐","李言","刘晨潇","刘佳明","刘健","刘文凯","陆永国","王之允","魏竟","周海军","周康康","王老师","蔡文丙"};
		int[] p={116605,101293,36726,31075,28984,25562,24963,6446,1436,864,25562,24963,6446,1436,864};
		String[] val={"1444","1179","1137","1217","1262","1134","1276","149","1274","1333","1143","1267","148","1273","145"};
		String[] picture={"feng.jpg","hao.jpg","baole.jpg","liyan.jpg","chenxiao.jpg","jiaming.jpg","liujian.jpg","liu.jpg","lu.jpg","wang.jpg","wei.jpg","haijun.jpg","zhou.jpg","sun.jpg","cai.jpg"};
		System.out.println(str.length);
		for(int i=0;i<15;i++){
			Reid r=new Reid();
			r.setName(str[i]);
			r.setPoll(p[i]);
			r.setPicture(picture[i]);
			map.put(val[i],r);
		}
		
        Map sortedMap=getsort(map);
        Set set = sortedMap.entrySet();
		
		for( Iterator it = set.iterator(); it.hasNext() ; ){
			Object obj = it.next();
			Entry entry = (Entry) obj;
			System.out.println(entry.getKey()+"....."+entry.getValue());
		}
		resource.set("优就业-JAVA1016班颜值评选".getBytes(),SerializationUtils.serialize(sortedMap));
		System.out.println("成功了");
		pool.close();
		resource.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static Map<String,Reid> getsort(Map<String,Reid> map){
		List list = new LinkedList(map.entrySet()); 
		// System.out.println("list:"+list);
		Collections.sort(list, new Comparator()
		{
		public int compare(Object o1, Object o2) 
		{
		return ((Comparable) ((Map.Entry) (o1)).getValue())
		.compareTo(((Map.Entry) (o2)).getValue());
		}
		});
		Map<String,Reid> sortedMap = new LinkedHashMap<>();

		for (Iterator it = list.iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry)it.next();
		sortedMap.put((String)entry.getKey(), (Reid)entry.getValue());
		} 
		
		return sortedMap;
	}
}
