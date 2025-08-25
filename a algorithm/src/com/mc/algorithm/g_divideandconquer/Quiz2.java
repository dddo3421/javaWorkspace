package com.mc.algorithm.g_divideandconquer;

public class Quiz2 {

    public static void main(String[] args) {
        coinCount(2000);
        
        greedyQuiz2();//탐욕법 회의실
    }

    private static void greedyQuiz2() {
		// TODO Auto-generated method stub
		
	}

	public static void coinCount(int money) {
        int a = money / 500; // 500원
        money %= 500;

        int b = money / 100; // 100원
        money %= 100;

        int c = money / 50; // 50원
        money %= 50;

        int d = money / 10; // 10원
        money %= 10;

        int e = money / 1; // 1원
        money %= 1;

        // 한 번만 출력
        String result = "{500:" + a + ", 100:" + b + ", 50:" + c + ", 10:" + d + ", 1:" + e + "}";
        System.out.println(result);
    }
}