package com.abe.API.model;

import java.util.List;

public class MessageWrapper {
	private List<MessageIn> message;

	public void setMessageIn(List<MessageIn> messageIn) {
		this.message = messageIn;
	}

	public List<MessageIn> getMessageIn() {
		return message;
	}

}
