package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.discount.policy.DiscountPolicy;
import com.mc.coffeemanager.domain.multilingual.payment.translate.Translatable;
import com.mc.coffeemanager.domain.order.Order;

public class Payment implements Translatable<Payment> {
	
	private Order order;
	private int paymentPrice;
	private DiscountPolicy discountPolicy;
	
	public Payment(Order order, DiscountPolicy discountPolicy) {
		this.order = order;
		this.paymentPrice = order.getOrderPrice();
		this.paymentPrice = discountPolicy.calculatePaymentPrice(order);
	}
	public Order getOrder() {
		return order;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void proceed() {
		Account account = Account.getInstance();
		account.registSales(paymentPrice);
		
	}
	@Override
	public String translate() {
	    String info = order.getName() + "잔" 
	                    + "\n" + paymentPrice + "원";
	    return info;  // 여기서 info를 반환
	}
	@Override
	public Payment origin() {
	    return this;  // 원본 Payment 반환
	}
	public String getOrderName() {
		return order.getName();
	}

}
