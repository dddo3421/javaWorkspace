package com.mc.coffeemanager.domain.multilingual.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public abstract class PaymentDecorator implements Translatable<Payment>{
	protected Translatable<Payment> target;

	public PaymentDecorator(Translatable<Payment> target) {
		super();
		this.target = target;
	}
	
	
}
