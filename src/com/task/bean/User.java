package com.task.bean;


public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String headPath;
	
	
	public Integer getId() {
		return id;
	}
	public User(Integer id, String username, String password, String email, String headPath) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.headPath = headPath;
	}
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", headPath=" + headPath + "]";
	}
	public User(Integer id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User() {
		super();
	}
	
	

}
