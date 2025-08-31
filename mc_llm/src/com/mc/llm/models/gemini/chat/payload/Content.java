package com.mc.llm.models.gemini.chat.payload;

import java.util.List;

public record Content (
		List<Part> parts,
		String role
		){
	
	
	public Content(List<Part> parts) {
		this(parts,null);
	}
}
