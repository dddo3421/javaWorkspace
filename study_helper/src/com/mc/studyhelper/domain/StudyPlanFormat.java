package com.mc.studyhelper.domain;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;

//난이도, 소요시간, 선행 프로그래밍언어, 프로젝트
public record StudyPlanFormat(
        SchemaType difficulty,
        SchemaType period,
        SchemaType firststepLanguage,
        SchemaType recommendedProject
) implements Format {

    public static final StudyPlanFormat INSTANCE =
            new StudyPlanFormat(SchemaType.STRING, SchemaType.STRING, SchemaType.STRING, SchemaType.STRING);
}
