package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.board.*;
import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.equipment.offensive.Lightning;
import fr.campus.dungeonsdragons.exception.OutOfBoardException;
import fr.campus.dungeonsdragons.enemy.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    /**
    private final Scanner scanner;
    private final Menu menu; **/
    private Character player;
    private int playerPosition; // 1 à 64
    private ArrayList<Cell> board;

    public Game() {
        board = new ArrayList<>();
        board.add(new EmptyCell(1));
        board.add(new DragonCell(2));
        board.add(new ClubCell(3));
        board.add(new SmallPotionCell(4));
        board.add(new BigPotionCell(5));
        board.add(new GoblinCell(6));
        board.add(new SorcererCell(7));
        board.add(new FireballCell(8));
        board.add(new LightningCell(9));
        board.add(new SwordCell(10));
        playerPosition = 0;
    }

    public String nextTurn(Character player, Scanner scanner) {
        System.out.println("TURN MENU");
        System.out.println("1. Roll the dice");
        System.out.println("2. Quit game");
        System.out.print("Your choice: ");
        String input = scanner.nextLine();

        if (input.equals("2")) {
            return "QUIT";
        }

        int diceRoll = 1;
        System.out.println("You rolled: " + diceRoll);

        if (playerPosition + diceRoll >= board.size()) {
            System.out.println("You reached the end of the board!");
            return "GAME_OVER";
        }

        playerPosition += diceRoll;
        Cell currentCell = board.get(playerPosition);
        System.out.println(currentCell.toString());

        return "IN_PROGRESS";
    }

    /**
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
        playerPosition = 1;

        while (playerPosition < 64) {
            System.out.println("TURN MENU");
            System.out.println("1. Roll the dice");
            System.out.println("2. Quit game");
            System.out.print("Your choice: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                int roll = rollDice();
                System.out.println("You rolled: " + roll);

                try {
                    movePlayer(roll);
                } catch (OutOfBoardException e) {
                    System.out.println("Warning! " + e.getMessage());
                }

                System.out.println("Current position: " + playerPosition + "/64");
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

    /**
     *
     * @param roll
     * @throws OutOfBoardException
     */
    /**
    private void movePlayer(int roll) throws OutOfBoardException {
        int nextPosition = playerPosition + roll;
        if (nextPosition > 64) {
            throw new OutOfBoardException("You cannot go beyond cell 64. You're at " + playerPosition + " and rolled a " + roll + ".");
        }
        playerPosition = nextPosition;
    }

    private int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }
    **/
}
