package com.abe.API.model;

import java.util.HashMap;
import java.util.Map;

public class Message {
	private String text;
	private String topic;
	private Long destination_id;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Long getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(Long destination_id) {
		this.destination_id = destination_id;
	}

	public Map<String, String> getAttributesAsMap() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("text", this.getText());
		attributes.put("topic", this.getTopic());
		attributes.put("destination_id",
				String.valueOf(this.getDestination_id()));
		return attributes;
	}

}
