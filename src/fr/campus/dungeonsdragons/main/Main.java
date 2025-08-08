package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.character.Character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);

        boolean playAgain = true;
        while (playAgain) {
            Character character = menu.createCharacter();
            Game game = new Game(menu);

            String gameState;
            do {
                gameState = game.nextTurn(character, scanner);
            } while (gameState.equals("IN_PROGRESS"));

            if (gameState.equals("WON")) {
                System.out.println("Game finished successfully!");
            } else if (gameState.equals("LOST")) {
                System.out.println("GAME OVER!");
            }

            boolean validResponse = false;
            while (!validResponse) {
                System.out.println("Do you want to play again? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no")) {
                    playAgain = false;
                    validResponse = true;
                    System.out.println("Thank you for playing. Goodbye!");
                } else if (response.equals("yes")) {
                    playAgain = true;
                    validResponse = true;
                } else {
                    System.out.print("Invalid input. ");
                }
            }
        }

        scanner.close();
    }
}
