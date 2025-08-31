package com.mc.llm.models;

public interface BaseModel {
	BaseResponse invoke(BaseRequest message);
}
