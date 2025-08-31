package com.mc.musiccoordinator.domain.song;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;

public record SongFormat(
		SchemaType name,
		SchemaType artist,
		SchemaType reason
	) implements Format{

	public static final SongFormat INSTANCE = new SongFormat(SchemaType.STRING,SchemaType.STRING, SchemaType.STRING);
	
	
}
