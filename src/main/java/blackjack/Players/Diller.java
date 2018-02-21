package blackjack.Players;


import blackjack.Deck.Card;
import blackjack.Deck.Deck;

import java.util.ArrayList;

public class Diller implements Player {

    private ArrayList<Card> cards = new ArrayList<>();
    private int points;
    private boolean isSay;
    private  String name;

    public String getName() {
        return name;
    }

    public void getCard(Deck deck) {
        Card card = deck.getCard();
        cards.add(card);
        points += card.getValue();
    }

    public boolean isSay() {
        if (points < 17){
            isSay = true;
        }else {
            isSay = false;
        }
        return isSay;

    }
    public ArrayList<Card> getDeck(){
        return cards;
    }

    public Diller(){
        this.name = "Диллер";
    }

    public int getPoints() {
        return points;
    }
}
