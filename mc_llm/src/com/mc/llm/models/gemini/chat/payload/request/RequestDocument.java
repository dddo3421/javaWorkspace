package com.mc.llm.models.gemini.chat.payload.request;

import java.util.List;

import com.mc.llm.models.gemini.chat.payload.Content;

public record RequestDocument<T>(
		List<Content> contents,
		GenerationConfig<T> generationConfig){	
}
