package com.mc.coffeemanager.domain.coffee;

import java.time.Month;
import java.time.LocalDate;

public class SeasonCoffee extends Coffee{

	private Month[] seasons;

	public SeasonCoffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt,
			Month[] seasons) {
		super(name, price, purchasePrice, stock, safetyStock, salesCnt);
		this.seasons = seasons;
	}
	
	public boolean isSeason() {
		System.out.println();
		Month now =  LocalDate.now().getMonth();
		for (Month month : seasons) {
			if(month.equals(now)) return true;
		}
		return false;
	}
	
}
