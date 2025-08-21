package com.mc.algorithm.b_star;

import java.util.Scanner;

public class Butterfly {
	
	public static void main(String[] args) {
		System.out.print("입력 : ");		
		int input = new Scanner(System.in).nextInt();
		
		for (int i = 0; i < input + 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			
			for (int j = 0; j < 2 * (input - i); j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			
			System.out.println();				
		}
		
		for (int i = 1; i < input; i++) {

			for (int j = 0; j < input - i; j++) {
				System.out.print("*");
			}
			
			for (int j = 0; j < 2 * i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < input - i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}

}
