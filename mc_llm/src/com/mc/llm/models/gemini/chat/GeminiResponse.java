package com.mc.llm.models.gemini.chat;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.mc.llm.models.BaseResponse;
import com.mc.llm.models.gemini.chat.payload.response.ResponseDocument;
import com.mc.llm.util.json.JsonProvider;

public class GeminiResponse implements BaseResponse{

	private String response;
	
	public GeminiResponse(String response) {
		super();
		this.response = response;
	}

	@Override
	public List<Map<String, Object>> messageToMap() {
		ResponseDocument doc = JsonProvider.gson().fromJson(response, ResponseDocument.class);
		String partText = doc
				.candidates().getFirst().content().parts().getFirst().text();
		
		TypeToken<List<Map<String, Object>>> listType = new TypeToken<List<Map<String, Object>>>() {};
		return JsonProvider.gson().fromJson(partText, listType.getType());
	}
}

