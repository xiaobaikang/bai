package com.offcn.controller;


import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.entity.Reid;
import com.offcn.reids.Reids;

@Controller
public class RedisController {

	
	@RequestMapping("getRedis")
	@ResponseBody
	public Map<String,Reid> getRedis(@Param("modelid")String modelid){
		System.out.println(modelid);
		System.out.println("aaaa");
		Reids reids=new Reids();
		Map<String,Reid> map=reids.getMap(modelid);
		System.out.println(map);
		Set set=new TreeSet();
		return map;
	}
	
	@RequestMapping("getRedisSet")
	@ResponseBody
	public Set<Reid> getRedisSet(@Param("modelid")int modelid){
		Reids reids=new Reids();
		Set<Reid> set=reids.getSet(modelid);
		
		return set;
	}
}
