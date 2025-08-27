package c_templatemethod;

import java.util.Random;

public class Thief extends Character{

	public Thief(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
		// TODO Auto-generated constructor stub
	}
	
	private Random random = new Random();

	// Theif 캐릭터의 공격 가중치는 atk/2 ~ atk * 5
	@Override
	protected int calAttackWeight() {
		Random random = new Random();
		return random.nextInt(atk/2, atk * 5);
	}

	@Override
	protected int calDefenseWeight(int damage) {
				if(random.nextInt(0,2) == 0) {
					System.out.println("[Thief 특성 발동] 공격이 빗나갑니다");
					return 0;
				}
		return damage - (damage * def / 100);
	}

}
