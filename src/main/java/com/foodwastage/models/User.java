package com.foodwastage.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	private int id;
	@Id
	private String userid;
	private String pwd;
	private String uname;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userid=" + userid + ", pwd=" + pwd + ", uname=" + uname + ", role=" + role + "]";
	}
	
	
}
