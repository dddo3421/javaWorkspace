package com.mc.algorithm.f_bruteforce.quiz;

public class Quiz { //종말의 수 문제, n번째로 666이 연속되는 수 구하기
	
	public static void main(String[] args) {
		
		q1(5);
		q2();
	}

	private static void q2() {
		
		
	}

	
	
	
	
	
	
	private static void q1(int i) {
		int[] dn = new int[i]; // 666이 연속되는 수를 저장할 배열
		
		int count = 0; // 저장할 666이 연속되는 수의 개수
		int number = 666; // 666부터 세기 시작함 
		
		while(count < i) { // 카운트가 i 보다 작으면 계속
			if(String.valueOf(number).contains("666")) { //number의 숫자를 문자열로 변환하고 666이 포함되어 있는지 검사
				dn[count++] = number; // 666이 포함되어 있으면 number 값을 dn 배열의 count번째 인덱스에 넣고 count 증가
			}
			number++; // number 증가
		}
		
		//출력
		System.out.println("입력값 : "+ i);
		System.out.println("결과 : " + dn[i-1]);
	}
	
}
