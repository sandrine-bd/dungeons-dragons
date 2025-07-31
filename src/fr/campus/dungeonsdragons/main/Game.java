package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.character.Character;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Menu menu;
    private Character player;
    private int position; // 1 à 64

    public Game(Scanner scanner, Menu menu) {
        this.scanner = scanner;
        this.menu = menu;
        this.position = 1;
    }

    public void launch() {
        boolean running = true;
        while (running) {
            menu.displayMainMenu();
            int choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    player = menu.createCharacter();
                    boolean wantsToPlay = handleCharacterSetup();
                    if (wantsToPlay) {
                        play();
                    }
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private boolean handleCharacterSetup() {
        boolean editing = true;
        while (editing) {
            menu.displayCharacterMenu(player);
            int choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    menu.showCharacter(player);
                    break;
                case 2:
                    menu.editCharacterName(player);
                    break;
                case 3:
                    return true;
                case 4:
                    System.out.println("Exiting to main menu...");
                    return false;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        return false;
    }

    private void play() {
        System.out.println("Game starts! You're on cell 1/64.");
        position = 1;

        while (position < 64) {
            System.out.println("TURN MENU");
            System.out.println("1. Roll the dice");
            System.out.println("2. Quit game");
            System.out.print("Your choice: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                int roll = rollDice();
                System.out.println("You rolled: " + roll);
                position += roll;
                if (position> 64) {
                    position = 64;
                }
                System.out.println("Current position: " + position + "/64");
            } else if (input.equals("2")) {
                System.out.println("Game aborted. Returning to main menu.");
                return;
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
        System.out.println("Congratulations! You've reached the end!");

        String again;
        while (true) {
            System.out.print("Play again? (yes/no): ");
            again = scanner.nextLine().trim();
            if (again.equalsIgnoreCase("yes")) {
                player = menu.createCharacter();
                if (handleCharacterSetup()) {
                    play();
                }
                return;
            } else if (again.equalsIgnoreCase("no")) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    private int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }
}
