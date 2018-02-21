package blackjack.Deck;

public class Card {

    private String suit;
    private String name;
    private int value;

    public Card(int suit, int name){
        String[] suits = {"Треф", "Пик", "Червы", "Буби"};
        this.suit = suits[suit];
        String[][] namesAndValues = {{"Двойка", "2"}, {"Тройка", "3"}, {"Четверка", "4"},
                {"Пятерка", "5"}, {"Шестерка", "6"}, {"Семерка", "7"},
                {"Восьмерка", "8"}, {"Девятка", "9"}, {"Десятка", "10"},
                {"Валет", "10"}, {"Дама", "10"}, {"Король", "10"}, {"Туз", "11"}};
        this.name = namesAndValues[name][0];
        this.value = Integer.parseInt(namesAndValues[name][1]);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " " + suit + " " + value + " " + "очков";
    }
}
