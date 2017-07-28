package com.javatpoint.beans;

public class StudentBean {
private int sid;
private String name,email,password,uname;
private long mobile;

public StudentBean() {}

public StudentBean(int sid, String name, String email,  long mobile , String uname , String password) {
	super();
	this.sid = sid;
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.uname = uname;
	this.password = password;
	
}
public StudentBean(String name, String email,  long mobile , String uname , String password) {
	super();
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.uname = uname;
	this.password = password;
}

public int getId() {
	return sid;
}
public void setId(int id) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getUName() {
	return uname;
}
public void setUName(String uname) {
	this.uname =uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
