package com.mc.coffeemanager.presentation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.multilingual.payment.translate.ChinaDecorator;
import com.mc.coffeemanager.domain.multilingual.payment.translate.SpainDecorator;
import com.mc.coffeemanager.domain.multilingual.payment.translate.Translatable;
import com.mc.coffeemanager.domain.multilingual.payment.translate.UsaDecorator;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.payment.Payment;
import com.mc.coffeemanager.domain.sale.SaleContext;

// presentation : 표현계층
// 서비스 외부의 요청을 받고 응답을 보내는 계층
public class Menu {
	
	private SaleContext saleContext = new SaleContext();
	private Coffee[] coffees;
	private Account account = Account.getInstance();
	
 	public Menu(Coffee[] coffees) {
		super();
		this.coffees = coffees;
	}

	public void menu(){
		
		while(true) {
			
			try {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("\n==== menu ====\n");
				System.out.println("판매등록(1)");
				System.out.println("현황(2)");
				System.out.println("종료(3)");

				System.out.print("입력 : ");
				int menu = sc.nextInt();

				if (menu == 3) {
					System.out.println("system : 종료합니다.");
					break;
				}

				if (menu < 1 || menu > 3) {
					System.out.println("system : 잘못 입력하셨습니다.");
					continue;
				}
				
				if (menu == 1) {
					System.out.println("\n==== list ====\n");
					for (int i = 0; i < coffees.length; i++) {
						System.out.println(coffees[i].getName() + "(" + i + ")");
					}

					System.out.print("번호 : ");
					int drinkNo = sc.nextInt();
					System.out.print("수량 : ");
					int orderCnt = sc.nextInt();

					if (drinkNo < 0 || drinkNo >= coffees.length) {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
				
					registOrder(drinkNo, orderCnt);
				}else {

					for (int i = 0; i < coffees.length; i++) {
						System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", 
								coffees[i].getName(), coffees[i].getStock(), coffees[i].getSalesCnt());
					}

					System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n"
							, account.getBalance(), account.getSales(), account.getExpences());
				}

			}catch (NoSuchElementException e) {
				System.out.println("잘못된 입력 값 입니다.");
				continue;
			}
		}
	}

	private void registOrder(int drinkNo, int orderCnt) {
		Scanner sc = new Scanner(System.in);
		Order order = Order.createOrder(coffees[drinkNo], orderCnt); 
		
		if(order.getStatus().isFail()) {
			System.out.println("system : " + order.getStatus().desc());
			return;
		}
		
		Translatable<Payment> payment = saleContext.init(order);
		
		while(true) {
			System.out.println("선택할 다국어");
			System.out.println("1. 영어");
			System.out.println("2. 중국어");
			System.out.println("3. 스페인어");
			System.out.println("4. 선택안함");
			int multilingual = sc.nextInt();
			if(multilingual == 4) break;
			
			// Spain -> China -> Usa -> Payment
			
			switch (multilingual) {
			case 1: {
				payment = new UsaDecorator(payment);
				break;
			}
			case 2: {
				payment = new ChinaDecorator(payment);
				break;
			}
			case 3: {
				payment = new SpainDecorator(payment);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + multilingual);
			}
		}

		System.out.println("\n 제품명 : " + coffees[drinkNo].getName() 
				+ "\n 판매가 : " + coffees[drinkNo].getPrice()
				+ "\n 판매수량 : " + orderCnt 
				+ "\n 남은 재고 : "+ coffees[drinkNo].getStock());
		
		System.out.println("========== 판매정보 ==========");
		System.out.println(payment.translate());
		

	}
	
	
	
	
	
}
