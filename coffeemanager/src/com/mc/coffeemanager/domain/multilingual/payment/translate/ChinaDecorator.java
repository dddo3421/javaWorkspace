package com.mc.coffeemanager.domain.multilingual.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class ChinaDecorator extends PaymentDecorator{

	public ChinaDecorator(Translatable<Payment> target) {
		super(target);
	}

	@Override
	public String translate() {
		String info = target.translate();
		Payment payment = origin();
		info += "\n" + payment.getOrderName() + "杯"
				+ "\n " + payment.getPaymentPrice()/200 + " wian";
		return info;
	}

	@Override
	public Payment origin() {
		return target.origin();
	}

}
