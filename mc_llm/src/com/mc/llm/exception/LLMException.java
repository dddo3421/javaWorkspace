package com.mc.llm.exception;

import com.mc.llm.exception.code.ErrorCode;

/***
 * 
 * LLM 공통모듈에서 발생하는 루트 예외입니다.
 */
public class LLMException extends RuntimeException{
	
	private final ErrorCode code;

	public LLMException(ErrorCode code) {
		super(code.message());
		this.code = code;
	}

	public LLMException(ErrorCode code, Throwable cause) {
		super(cause);
		this.code = code;
	}
	
	public LLMException(ErrorCode code, String message) {
		super(message);
		this.code = code;
	}
	
	public ErrorCode code(){
		return code;
	}
	
}
