package e_game.event;

import java.util.Random;
import java.util.Scanner;

import d_strategy.Character.Monster;
import d_strategy.Character.Player;
import d_strategy.item.Equipment;
import d_strategy.item.code.EquipmentData;

public class BattleEvent implements Event {
	
	
	private Player player;
     Monster monster = new Monster("슬라임", 200, 30, 10);

    public BattleEvent(Player player) {
        this.player = player;
    
    }
    
	@Override
	public void execute() {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		System.out.println("전투 발생!");

		boolean eventFlg = true;
		while (true) {

			if (player.isDead()) {
				System.out.println("\n======================================");
				System.out.println("용사가 사망하여 모험이 종료됩니다");
				break;
			}

			if (monster.isDead()) {
				System.out.println("\n======================================");
				System.out.println("전투에서 승리했습니다!");
				break;
			}

			System.out.println("\n======================================");
			sc.nextLine();

			if (player.getCurrentHp() < 150) {
				System.out.println(EquipmentData.valueOf("BASIC_WEAPON"));
				EquipmentData[] datas = EquipmentData.values(); 
				int index = random.nextInt(0, datas.length);

				if (eventFlg) {
					Equipment equipment = datas[index].create();
					System.out.println(equipment.getName() + " 발견했습니다.");
					player.equip(datas[index].create());
					eventFlg = false;
				}
			}

			player.attack(monster);
			monster.attack(player);
			System.out.println("------------------------------------");
			System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
			System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
		}

	}
}
