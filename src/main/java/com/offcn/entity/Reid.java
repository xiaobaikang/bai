package com.offcn.entity;

import java.io.Serializable;

public class Reid implements Comparable,Serializable{

	private int id;
	private String name;
	private int poll;
	private String picture;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoll() {
		return poll;
	}


	public void setPoll(int poll) {
		this.poll = poll;
	}


	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Reid)){
			throw new ClassCastException("传递的对象不是Reid类");
		}
		Reid r=(Reid) o;
		int temp=r.poll-this.poll;
		return temp == 0 ? this.name.compareTo(r.name) : temp;
	}


	@Override
	public String toString() {
		return "{name:" + name + ", poll:" + poll + ", picture:" + picture + "}";
	}


	
	
	
}
