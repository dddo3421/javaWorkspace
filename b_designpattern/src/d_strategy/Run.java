package d_strategy;

import java.util.Random;
import java.util.Scanner;

import d_strategy.Character.Monster;
import d_strategy.Character.Player;
import d_strategy.item.Equipment;
import d_strategy.item.code.EquipmentData;

// Strategy 패턴
// 코드를 재사용해야 하는 경우
// Interface, 합성을 활용해 코드를 재사용하고 기능을 동적으로 확장
// 실행시점에 변경될 로직을 결정할 수 있다. (lazy binding, dynamic binding)
public class Run {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		Player player = new Player("지존짱짱맨", 200, 30, 10);
		Monster monster = new Monster("슬라임", 200, 30, 10);
		
		System.out.println("[전투이벤트] " + monster.getName() + " 등장!");
		boolean eventFlg = true;
		while(true) {
			
			if(player.isDead()) {
				System.out.println("\n======================================");
				System.out.println("[결과] LOSE");
				break;
			}
			
			if(monster.isDead()) {
				System.out.println("\n======================================");
				System.out.println("[결과] WIN");
				break;
			}
			
			System.out.println("\n======================================");
			sc.nextLine();
			
			if(player.getCurrentHp() < 150) {
				System.out.println(EquipmentData.valueOf("BASIC_WEAPON"));
				EquipmentData[] datas = EquipmentData.values(); // Enum 상수를 순서대로 배열로 반환
				int index = random.nextInt(0, datas.length);
				
				if(eventFlg) {
					// 전략을 생성					
					// 전략을 주입, Dependency Injection, Inversion of Controller
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

