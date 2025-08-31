package com.mc.llm.models.gemini.chat.payload.response;

import com.mc.llm.models.gemini.chat.payload.Content;

public record Candidate(
		Content content,
		String finishReason,
		int index
		) {

}
