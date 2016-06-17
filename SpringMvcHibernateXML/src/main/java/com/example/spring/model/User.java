package com.example.spring.model;

import java.util.Arrays;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
    private String manager;
    private String projectName;
    private String[] subOrdinateList;
    private String managerEmail;
    
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append(", manager=");
		builder.append(manager);
		builder.append(", projectName=");
		builder.append(projectName);
		builder.append(", subOrdinateList=");
		builder.append(Arrays.toString(subOrdinateList));
		builder.append(", managerEmail=");
		builder.append(managerEmail);
		builder.append("]");
		return builder.toString();
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String[] getSubOrdinateList() {
		return subOrdinateList;
	}
	public void setSubOrdinateList(String[] subOrdinateList) {
		this.subOrdinateList = subOrdinateList;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
    
    
    
	
	

}
