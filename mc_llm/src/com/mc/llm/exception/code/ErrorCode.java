package com.mc.llm.exception.code;

public enum ErrorCode {
	INVALID_API_KEY("LM4030", "유효하지 않은 API-KEY입니다."),
	BAD_REQUEST("LM4000", "잘못된 요청입니다."),
	INTERNAL_SERVER_ERROR("LM5000", "서버에러입니다.");
	
	private String code;
	private String message;
	
	private ErrorCode(String code, String message) {
		
		this.code = code;
		this.message = message;
	}
	
	public String code() {return this.code;};
	public String message() { return message;};
	
}
