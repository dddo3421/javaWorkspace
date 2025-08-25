package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.util.SortUtil;

public class Quiz {

	public static void main(String[] args) {
		abc();
		int a = 0;
		int b = 0;
		q1(a,b);
	}

	
	
	
	// 매개변수 a,b를 받아 a의 b제곱 값을 반환하는 함수, 시간복잡도는 O(logN)
	private static void q1(int a, int b) {
		// TODO Auto-generated method stub
		
	}





	private static void abc() {
		int size = 10240;
		int[][] dArr = new int[size][size];

		SortUtil.checkTime(() -> {
			for (int i = 0; i < dArr.length; i++) {
				for (int j = 0; j < dArr.length; j++) {
					dArr[i][j] = i;
				}
			}
		});
	}

}
