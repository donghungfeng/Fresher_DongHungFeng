package com.api;

import org.springframework.stereotype.Component;

@Component
public class GroupTopic {
	private int grouptopicid;
	private String name;
	private String description;
	public GroupTopic(int grouptopicid,String name, String description) {
		this.grouptopicid = grouptopicid;
		this.name = name;
		this.description = description;
	}
	public GroupTopic() {
		
	}
	public int getGrouptopicid() {
		return grouptopicid;
	}
	public void setGrouptopicid(int grouptopicid) {
		this.grouptopicid = grouptopicid;
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
	
}
