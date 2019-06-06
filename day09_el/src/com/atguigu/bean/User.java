package com.atguigu.bean;

public class User {
	private Integer id;
	private String name1;
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName1() {
		return name1;
	}
	public void setName(String name) {
		this.name1 = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name1 + ", email=" + email + "]";
	}
	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name1 = name;
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
