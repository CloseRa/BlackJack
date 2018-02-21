package blackjack;

import blackjack.Players.Human;
import blackjack.Players.Player;

public class Start {
    public static void main (String args[]){
        Player player = new Human();
        Engine engine = new Engine(player);
        engine.start();
    }
}

