package com.test.spring;

public class EditDTO {
	
	private int seq;
	private String name;
	private String place;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		return "EditDTO [seq=" + seq + ", name=" + name + ", place=" + place + "]";
	}
	
	
	
}
