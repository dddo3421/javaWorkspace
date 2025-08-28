package com.mc.coffeemanager.domain.multilingual.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class UsaDecorator extends PaymentDecorator{

	public UsaDecorator(Translatable<Payment> target) {
		super(target);
	}

	@Override
	public String translate() {
		String info = target.translate();
		Payment payment = origin();
		
		// 디미터의 법칙 : 객체의 내부속성에 대해 몰라야한다.
		// 도메인 객체일 경우에만 해당됨
		// DTO, VO, 자료구조
		
		int price = Math.max(payment.getPaymentPrice()/1300, 1);
		info += "\n" + payment.getOrderName() + "cup"
				+ "\n " + price + " dollar";
		return info;
	}

	@Override
	public Payment origin() {
		return target.origin();
	}

}
