package com.spectramd.portal.model;

import com.google.gson.Gson;

import lombok.Data;

@Data
public class MessageJSONResponse {
	
	/*
	 * Response as a Message
	 */
	private String messageResponse;
	
	public MessageJSONResponse(String message) {
		messageResponse = new Gson().toJson(message);
	}
}
