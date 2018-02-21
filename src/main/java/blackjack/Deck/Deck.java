package blackjack.Deck;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(){
        ArrayList<Card> deck = createDeck();
        this.deck.addAll(mix(deck));
    }

    private ArrayList<Card> createDeck(){
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 0;i < 4;i++) {
            for (int j = 0;j < 13;j++){
                deck.add(new Card(i,j));
            }
        }
        return deck;
    }

    private ArrayList<Card> mix( ArrayList<Card> cards){
        ArrayList<Card> mixed = new ArrayList<>();
        Random randID = new Random();
        while (!cards.isEmpty()){
            int id = randID.nextInt(cards.size());
            mixed.add(cards.get(id));
            cards.remove(id);
        }
        return mixed;
    }

    public Card getCard(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
}