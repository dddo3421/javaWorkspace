package com.mc.coffeemanager.domain.multilingual.payment.translate;

public interface Translatable<T> {
	
	String translate();
	T origin();
}
