package c_templatemethod;

import java.util.Random;

public class Warrior extends Character{

	public Warrior(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
		// TODO Auto-generated constructor stub
	}
	
	// Warrior 캐릭터의 공격 가중치 atk ~ atk * 4
	@Override
	protected int calAttackWeight() {
		Random random = new Random();
		return random.nextInt(atk, atk * 4);
	}

	
	//방어 가중치 damage 의 30%를 감소시킴
	@Override
	protected int calDefenseWeight(int damage) {
		return damage * 70 / 100 * (100 - def) / 100;
	}

}
