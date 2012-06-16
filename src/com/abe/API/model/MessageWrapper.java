package com.abe.API.model;

import java.util.List;

public class MessageWrapper {
	private List<MessageIn> messageIn;

	public void setMessageIn(List<MessageIn> messageIn) {
		this.messageIn = messageIn;
	}

	public List<MessageIn> getMessageIn() {
		return messageIn;
	}

}
