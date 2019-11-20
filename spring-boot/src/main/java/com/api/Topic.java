package com.api;

import org.springframework.stereotype.Component;

@Component
public class Topic {
	private String id;
	private String name;
	private String description;
	private int groupid;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public Topic() {
		
	}

	public Topic(String id, String name, String description,int groupid) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.groupid = groupid;
	}
	
}
