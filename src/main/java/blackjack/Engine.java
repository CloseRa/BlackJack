package blackjack;

import blackjack.Deck.Deck;
import blackjack.Players.Diller;
import blackjack.Players.Player;

import java.util.Scanner;

public class Engine {

    private Player player;
    private Player diller;
    private Deck cardDeck = new Deck();
    private boolean finish = false;
    private boolean win = false;
    private int i = 0;

    void start(){
        startPlayer(player);
        if (!finish) {
            diller = new Diller();
            startPlayer(diller);
            checkResult();
        }
        if (win) {
            System.out.println("Ты жулик! Нечестно победил! А теперь, умри!");
            System.out.println("Напишите - 'бум' в течении 5 секунд или погибнете!");
            Thread thread = new Thread() {
                public void run() {
                    while (i < 5) {
                        i++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            System.out.println(answer);
            if(!answer.equals("бум")|| i == 5){
                System.out.println("Вы не успеваете среагировать, и вражеская пуля вышибает ваши мозги!");
            }else {
                System.out.println("Вы успеваете выстрелить первым, и забираете честно выигранные деньги, у мертвого противника!");
            }
        }

    }
    Engine(Player player){
        this.player = player;
    }

    private void printResult(Player one, Player two) {
        if (!finish) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Победил ")
                    .append(one.getName()).append(" с результатом ")
                    .append(one.getPoints()).append(" Против ")
                    .append(two.getName()).append(" с результатом ")
                    .append(two.getPoints())
                    .append("\n Вы проиграли, отдавайте все свои деньги!");
            System.out.println(stringBuilder);
        }
    }
    private void printResult(boolean blackjack, Player one){
        StringBuilder stringBuilder = new StringBuilder();
        String condition;
        String result;
        if (blackjack){
            condition = "Блек-Джек!";
            result = " ты победил! Можешь забрать свой выигрыш.";
        }else {
            condition = "Перебор!";
            result = " ,к сожалению ты всё проиграл!";

        }
        System.out.println(stringBuilder.append("Карты:")
                .append(one.getDeck())
                .append("\n").append(condition).append("\n")
                .append(one.getName()).append(result));

    }

    private void checkResult(){
        if(player.getPoints() > diller.getPoints()){
            printResult(player,diller);
            win = true;
        }else if (player.getPoints() < diller.getPoints()){
            printResult(diller,player);
        }else{
            System.out.println("Ничья!");
        }
    }

    private void startPlayer(Player player){
        int points;
        player.getCard(cardDeck);
        do {
            player.getCard(cardDeck);
            points = player.getPoints();
            if (points == 21){
                finish = true;
                printResult(true,player);
                if (player == this.player){
                    win = true;
                }
                break;
            }else  if (points > 21){
                finish = true;
                printResult(false,player);
                if (player == this.diller){
                    win = true;
                }
                break;
            }

        }while(player.isSay());
    }
}
