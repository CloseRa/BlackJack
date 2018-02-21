package blackjack.Players;

import blackjack.Deck.Card;
import blackjack.Deck.Deck;

import java.util.ArrayList;

public interface Player {
    String getName();
    void getCard(Deck deck);
    boolean isSay();
    int getPoints();
    ArrayList<Card> getDeck();
}