package com.mc.studyhelper.presetation;

import java.util.Scanner;

import com.mc.studyhelper.domain.StudyPlan;

public class Menu {
	
		public void menu() {
			Scanner sc = new Scanner(System.in);
			System.out.println("공부하고 싶은 프로그래밍언어를 입력하세요 : ");
			String inp = sc.nextLine();
			
			// 난이도, 소요시간, 선행 프로그래밍언어, 프로젝트
			StudyHelper helper = new StudyHelper();
			StudyPlan plan = helper.execute(inp);
			
			System.out.println(plan);
			
		}
}
