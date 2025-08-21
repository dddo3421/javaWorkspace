package com.mc.algorithm.a_ot;

public class Run {

	public static void main(String[] args) {
		
		//swap();
		//swapUsingBits();
	}

	private static void swapUsingBits() {
		int a = 11;
		int b = 16;
		
		// (a ^ b) ^ b = a
		// (a ^ b) ^ a = b
		a = a ^ b;
		
		b = a ^ b;
		a = b ^ a;
		
		System.out.println(a);
		System.out.println(b);
		
		// a xor 0 은 언제나 a
		// a xor 1 은 언제나 not a
		
		// a =  1001
		// b =  0101
		
		//      1100
		//      0101
		//      1001  		
	}

	private static void swap() {
		// a 에 담긴 값을 b 에, b 에 담긴 값을 a 에 넣어주세요.
		// 단 대입연산자만 사용해야합니다.
		// 값을 직접 변수에 할당할 수 는 없습니다.
		int a = 10;
		int b = 15;
		
		int temp = b;
		b = a;
		a = temp;
		
		System.out.println(a);
		System.out.println(b);
	}

}
