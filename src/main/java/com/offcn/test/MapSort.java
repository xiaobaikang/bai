package com.offcn.test;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Map.Entry;
	import java.util.TreeMap;

	/**
	 * Map������
	 * 
	 * @author root
	 *
	 */
	public class MapSort {
	    /**
	     * TreeMap����key��������
	     */
	    public static void TreeMapSortByKey() {
	        Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
	            @Override
	            public int compare(String o1, String o2) {
	                // ��������
	                return o2.compareTo(o1);
	            }
	        });
	        map.put("c", "ccccc");
	        map.put("a", "aaaaa");
	        map.put("b", "bbbbb");
	        map.put("d", "ddddd");
	        for (String key : map.keySet()) {
	            System.err.println("key:" + key + "  value:" + map.get(key));
	        }
	    }

	    /**
	     * TreeMap����value����
	     */
	    public static void TreeMapSortByValue() {
	        Map<String, String> map = new TreeMap<String, String>();
	        map.put("d", "ccccc");
	        map.put("b", "bbbbb");
	        map.put("a", "eeeee");
	        map.put("c", "ddddd");
	        // ��map.entrySet()ת����list
	        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
	        // ͨ���Ƚ�����ʵ������
	        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
	            @Override
	            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
	                // ��������
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });
	        for (Map.Entry<String, String> mapping : list) {
	            System.out.println(mapping.getKey() + ":" + mapping.getValue());
	        }
	    }

	    /**
	     * Map����Key����
	     */
	    public static void MapSortByKey() {
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("d", "ccccc");
	        map.put("b", "bbbbb");
	        map.put("a", "eeeee");
	        map.put("c", "ddddd");
	        // ��map.entrySet()ת����list
	        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
	        // ͨ���Ƚ�����ʵ������
	        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
	            @Override
	            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
	                // ��������
	                return o1.getKey().compareTo(o2.getKey());
	            }
	        });
	        for (Map.Entry<String, String> mapping : list) {
	            System.out.println(mapping.getKey() + ":" + mapping.getValue());
	        }
	    }

	    /**
	     * Map����Value����
	     */
	    public static void MapSortByValue() {
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("d", "ccccc");
	        map.put("b", "bbbbb");
	        map.put("a", "eeeee");
	        map.put("c", "ddddd");
	        // ��map.entrySet()ת����list
	        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
	        // ͨ���Ƚ�����ʵ������
	        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
	            @Override
	            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
	                // ��������
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });
	        for (Map.Entry<String, String> mapping : list) {
	            System.out.println("key:"+mapping.getKey() + "  value:" + mapping.getValue());
	        }
	    }

	    public static void main(String[] args) {
	        // MapSort.TreeMapSortByKey();
	        // MapSort.TreeMapSortByValue();
	        MapSort.MapSortByKey();
	        MapSort.MapSortByValue();
	    }
	
}
