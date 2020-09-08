package com.rest.api;

import java.util.List;

public class StudentDetails extends StudentAddress {
	private int id;
	private String name;
	private List<Integer> marks;
	private List<String> contact;
	private List<StudentAddress> address;
	//private String state;
	
	public List<StudentAddress> getAddress() {
		return address;
	}
	public void setAddress(List<StudentAddress> address) {
		this.address = address;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public List<String> getContact() {
		return contact;
	}
	public void setContact(List<String> contact) {
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
