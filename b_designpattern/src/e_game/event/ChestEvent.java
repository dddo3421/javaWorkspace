package e_game.event;

import d_strategy.Character.Player;

public class ChestEvent implements Event {
    private Player player;

    public ChestEvent(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("보물상자를 발견했습니다!");      
    }
}
