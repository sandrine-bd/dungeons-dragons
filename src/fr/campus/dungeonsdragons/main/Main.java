package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.character.Character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Character player = menu.createCharacter();
        Game game = new Game();

        String gameState;
        do {
            gameState = game.nextTurn(player, scanner);
        } while (gameState.equals("IN_PROGRESS"));

        if (gameState.equals("GAME_OVER")) {
            System.out.println("Game finished successfully!");
        } else if (gameState.equals("QUIT")) {
            System.out.println("Game aborted by the player.");
        }

        scanner.close();
    }
}
