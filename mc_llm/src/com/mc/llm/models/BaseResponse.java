package com.mc.llm.models;

import java.util.List;
import java.util.Map;

public interface BaseResponse {	
	List<Map<String, Object>> messageToMap();

}
