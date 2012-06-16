package com.abe.API.model;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String name;
	private String mail;
	private String password;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, String> getAttributesAsMap() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("name", this.getName());
		attributes.put("mail", this.getMail());
		attributes.put("password", this.getPassword());
		attributes.put("description", this.getDescription());
		return attributes;
	}
}
