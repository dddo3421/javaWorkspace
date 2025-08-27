package e_game;

import java.util.Scanner;

import d_strategy.Character.Player;
import e_game.event.*;

public class Run {
	
    public static void main(String[] args) {
    	
    	Player player = new Player("용사", 200, 30, 10); 
    	EventList eventList = new EventList(player);
        Scanner sc = new Scanner(System.in);

        for (int day = 1; day <= 8; day++) {
            System.out.println("===== Day " + day + " =====");

            Event todayEvent = (day == 8) ? new BattleEvent(player) : eventList.getRandomEvent();

            todayEvent.execute();

            if (player.isDead()) {
                System.out.println("용사가 사망하여 모험이 종료됩니다.");
                break;
            }

            sc.nextLine();
        }
    }
}
