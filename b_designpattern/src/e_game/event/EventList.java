package e_game.event;

import java.util.Random;
import d_strategy.Character.Player;

public class EventList {

    private Event[] events;
    private Random random = new Random();

    public EventList(Player player) {
        events = new Event[] {
            new BattleEvent(player),  
            new FoodEvent(player),
            new ChestEvent(player)
        };
    }

    public Event getRandomEvent() {
        int idx = random.nextInt(events.length);
        return events[idx];
    }
}
