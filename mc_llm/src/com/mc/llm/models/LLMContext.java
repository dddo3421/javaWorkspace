package com.mc.llm.models;

import com.mc.llm.models.gemini.chat.GeminiChatModel;

public class LLMContext {
	
	public BaseModel initChatModel(String url, LLMProvider provider) {
		return switch(provider) {
		case GEMINI -> GeminiChatModel.getInstanc(url);
		};		
	};
}
