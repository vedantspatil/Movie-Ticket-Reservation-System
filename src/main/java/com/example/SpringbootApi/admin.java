package com.example.SpringbootApi;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class admin {

	public String name;
	@Id
	public String uid;
	public String password;

	@Override
	public String toString() {
		return "User [name=" + name + ", uid=" + uid + ", password=" + password + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
