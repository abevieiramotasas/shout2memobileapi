package com.abe.API.model;

import java.util.List;

public class MessageWrapper {
	private List<MessageIn> messages;

	public void setMessageIn(List<MessageIn> messageIn) {
		this.messages = messageIn;
	}

	public List<MessageIn> getMessageIn() {
		return messages;
	}

}
