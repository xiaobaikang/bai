package com.offcn.test;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		
		//创建对象
		TreeMap map = new TreeMap(  );
		
		map.put(2, "上海");
		map.put(3, "上海");
		map.put(1, "北京");
		map.put(4, "东莞");
		
		//使用entrySet方法进行遍历
		Set set = map.entrySet();
		
		for( Iterator it = set.iterator(); it.hasNext() ; ){
			Object obj = it.next();
			Entry entry = (Entry) obj;
			System.out.println(entry.getKey()+"....."+entry.getValue());
		}
	}
}