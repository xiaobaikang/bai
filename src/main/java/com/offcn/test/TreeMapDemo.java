package com.offcn.test;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		
		//��������
		TreeMap map = new TreeMap(  );
		
		map.put(2, "�Ϻ�");
		map.put(3, "�Ϻ�");
		map.put(1, "����");
		map.put(4, "��ݸ");
		
		//ʹ��entrySet�������б���
		Set set = map.entrySet();
		
		for( Iterator it = set.iterator(); it.hasNext() ; ){
			Object obj = it.next();
			Entry entry = (Entry) obj;
			System.out.println(entry.getKey()+"....."+entry.getValue());
		}
	}
}