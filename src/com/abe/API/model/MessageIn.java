package com.abe.API.model;

/**
 * message's information retrieved
 * 
 * @author abelardo
 * 
 */
public class MessageIn {
	private Long message_id;
	private String text;
	private String topic;
	private Long author_id;
	private String author_name;
	private Long date_in_millis;
	private Long destination_id;

	public Long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}

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

	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Long getDate_in_millis() {
		return date_in_millis;
	}

	public void setDate_in_millis(Long date_in_millis) {
		this.date_in_millis = date_in_millis;
	}

	public Long getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(Long destination_id) {
		this.destination_id = destination_id;
	}

}
