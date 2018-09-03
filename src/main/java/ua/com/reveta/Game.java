package ua.com.reveta;

import ua.com.reveta.objects.Desk;
import ua.com.reveta.objects.Figura;

import java.util.Scanner;

public class Game {

    private Players player;
    private Desk desk;

    enum Players {player_1, player_2}

    public Game() {
        desk = new Desk();
        this.player = Players.player_1;
    }

    public void startGame() {

        boolean gameStatus = true;

        while (gameStatus) {
            desk.deskToConsole();
            nextStep();
        }
    }

    private void nextStep() {
        player = (player != Players.player_1) ? Players.player_1 : Players.player_2;

        System.out.println("Гравець: " + player + " введіть клітинку: ");
        int scanner = new Scanner(System.in).nextInt();
        desk.setFigura(
                scanner -1,
                (player == Players.player_1) ? Figura.Status.X : Figura.Status.O
        );
    }
}
