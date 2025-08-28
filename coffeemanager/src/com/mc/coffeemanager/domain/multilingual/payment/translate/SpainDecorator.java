package com.mc.coffeemanager.domain.multilingual.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class SpainDecorator extends PaymentDecorator{

	public SpainDecorator(Translatable<Payment> target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String translate() {
		String info = target.translate();
		Payment payment = origin();
		
		int price = Math.max(payment.getPaymentPrice()/1300, 1);
		info += "\n" + payment.getOrderName() + "tazas de"
				+ "\n " + price + " eur";
		return info;
	}

	@Override
	public Payment origin() {
		return target.origin();
	}

}
