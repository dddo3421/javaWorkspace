package e_game.event;

import d_strategy.Character.Player;

public class FoodEvent implements Event {
    private Player player;

    public FoodEvent(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("음식을 발견했습니다!");
        player.healToFull();
        System.out.println("체력이 최대치로 회복되었습니다");
    }
}
