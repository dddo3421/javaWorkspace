package com.mc.llm.models.gemini.chat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mc.llm.exception.LLMException;
import com.mc.llm.exception.code.ErrorCode;
import com.mc.llm.models.BaseModel;
import com.mc.llm.models.BaseRequest;
import com.mc.llm.models.BaseResponse;
import com.mc.llm.models.gemini.chat.payload.error.GeminiErrorMessage;
import com.mc.llm.util.json.JsonProvider;

public class GeminiChatModel implements BaseModel{
	
	
	
	private final String API_URL;
	private final String API_KEY;
	private static GeminiChatModel INSTANCE;
	
	public static GeminiChatModel getInstanc(String url) {
		if(INSTANCE == null) {
			INSTANCE = new GeminiChatModel(url);
		}
		return INSTANCE;
}
	
	public GeminiChatModel(String url) {
		super();
		API_URL = url;
		API_KEY = System.getenv("GEMINI_API_KEY");
		if(API_KEY == null) throw new LLMException(ErrorCode.BAD_REQUEST
				,"환경변수에 GEMINI_API_KEY가 존재하지 않습니다.");
	}

	@Override
	public BaseResponse invoke(BaseRequest message) {
		String body = message.messageToJson();
		
		//TODO API 코드를 환경변수에서 받아오도록 변경
		try(HttpClient client = HttpClient.newHttpClient()){
			HttpRequest request = HttpRequest.newBuilder()
				     .uri(URI.create(API_URL))
				     .timeout(Duration.ofSeconds(15))
				     .header("X-goog-api-key", API_KEY)
				     .header("Content-Type", "application/json")
				     .POST(BodyPublishers.ofString(body))
				     .build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			if(response.statusCode() < 200 || response.statusCode() > 299) {
				
				if(response.statusCode() == 404) {
					throw new LLMException(ErrorCode.BAD_REQUEST,"잘못된 API URL 입니다.");
				}
				
				JsonObject jsonObject
				= JsonProvider.gson().fromJson(response.body(), JsonObject.class);
				
				GeminiErrorMessage errorMessage 
					= JsonProvider.gson().fromJson(jsonObject.get("error"),GeminiErrorMessage.class);
				
				System.out.println(errorMessage);
				throw new LLMException(ErrorCode.BAD_REQUEST, errorMessage.message());
			}
			
			return new GeminiResponse(response.body());
			
		}catch (IOException | InterruptedException e) {
			throw new LLMException(ErrorCode.INTERNAL_SERVER_ERROR, e);
		}
	}
	
	
	
	
	
	

}
