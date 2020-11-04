package com.example.user.UserManagementApplication;

import javax.persistence.Entity;
import javax.persistence.Id;

// model class
@Entity
public class User {
	@Id
	private String uid;
	private String uname;
	private String uage;
	public User(String uid, String uname, String uage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
	}
	public User() {
		super();
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUage() {
		return uage;
	}
	public void setUage(String uage) {
		this.uage = uage;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uage=" + uage + "]";
	}
	
	
}
