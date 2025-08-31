package com.mc.llm.models.gemini.chat.payload.request;

public record Items<T>(
		String type,
		T properties
		) {

	public Items(T properties) {
		this("OBJECT", properties);
	}
}
