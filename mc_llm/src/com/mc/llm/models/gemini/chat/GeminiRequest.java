package com.mc.llm.models.gemini.chat;

import java.util.List;

import com.mc.llm.models.BaseRequest;
import com.mc.llm.models.gemini.chat.payload.Content;
import com.mc.llm.models.gemini.chat.payload.Part;
import com.mc.llm.models.gemini.chat.payload.request.GenerationConfig;
import com.mc.llm.models.gemini.chat.payload.request.Items;
import com.mc.llm.models.gemini.chat.payload.request.RequestDocument;
import com.mc.llm.models.gemini.chat.payload.request.ResponseSchema;
import com.mc.llm.util.json.JsonProvider;

public class GeminiRequest<T extends Format> implements BaseRequest {

	private String content;
	private T format;

	public GeminiRequest(String content, T format) {
		super();
		this.content = content;
		this.format = format;
	}

	@Override

	public String messageToJson() {
		ResponseSchema<T> schema
		= new ResponseSchema<T>(new Items<>(format));

		GenerationConfig<T> config
		= new GenerationConfig<>(schema);

		RequestDocument<T> doc 
		= new RequestDocument<>(List.of(new Content(List.of(new Part(content)))), config);


		return JsonProvider.gson().toJson(doc);
		
	}

}
