package com.abe.API.model;

import java.util.HashMap;
import java.util.Map;

public class Island {

	private String name;
	private Double longitude;
	private Double latitude;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
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
		attributes.put("longitude", String.valueOf(this.getLongitude()));
		attributes.put("latitude", String.valueOf(this.getLatitude()));
		attributes.put("description", String.valueOf(this.getDescription()));
		return attributes;
	}

}
