package blackjack.Players;

import blackjack.Deck.Card;
import blackjack.Deck.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class Human implements Player {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private int points;
    private String name;

    public String getName() {
        return name;
    }

    public void getCard(Deck deck) {
        Card card = deck.getCard();
        cards.add(card);
        points += card.getValue();
    }

    public boolean isSay() {
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.append("Ваши карты:\n")
                .append(getDeck()).append("\nВсего очков: ")
                .append(points));

        Scanner scanner = new Scanner(System.in);
        String strToConsol;
        boolean answer;
        while (true){
            strToConsol = scanner.next();
            if (strToConsol.trim().equals("всё")){
                answer = false;
                break;
            }else  if(strToConsol.trim().equals("ещё")){
                answer = true;
                break;
            }else {
                System.err.println("Введено неверное значение! Повторите попытку.");
            }
        }
        return answer;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }

    public Human() {
        System.out.println("Как вас зовут?:\n");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.append("Добро пожаловать: ")
                .append(name)
                .append("\nСыграем в Блек Джек! Победитель забирает всё!")
                .append("\nЕсли хотите взять дополнительную карту, введите - \"взять\"")
                .append("\nЕсли хотите оставить все как есть, введите - \"оставить\""));
    }
}
