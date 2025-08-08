package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.board.Board;
import fr.campus.dungeonsdragons.board.Cell;
import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.exception.OutOfBoardException;

import java.util.Scanner;
import java.util.Random;

public class Game {
    private final Board board;
    private int playerPosition = 0;
    private boolean isGameOver = false;
    private final Random dice;
    private final Menu menu;

    public Game(Menu menu) {
        this.board = new Board();
        this.dice = new Random();
        this.menu = menu;
    }

    public String nextTurn(Character character, Scanner scanner) {
        while (true) {
            System.out.println("\n--- NEW TURN ---");
            System.out.println("1. Roll the dice");
            System.out.println("2. Go to Menu");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                int roll = rollDice();
                System.out.println("\nYou rolled a " + roll + ".");

                try {
                    movePlayer(roll);
                } catch (OutOfBoardException e) {
                    System.out.println("You've reached the end of the board. YOU WIN!");
                    return "WON";
                }

                Cell cell = board.getCell(playerPosition);
                System.out.println(cell);
                cell.interact(character);

                if (character.getLifePoints() <= 0) {
                    System.out.println(" ");
                    isGameOver = true;
                    return "LOST";
                }
                return "IN_PROGRESS";
            } else if (choice.equals("2")) {
                menu.displayMenu(character);
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
    }

    private int rollDice() {
        return dice.nextInt(6) + 1;
    }

    private void movePlayer(int roll) throws OutOfBoardException {
        if (playerPosition + roll >= board.getSize()) {
            throw new OutOfBoardException("Cannot move beyond board limit.");
        }
        playerPosition += roll;
        System.out.println("You move to cell " + playerPosition + ".");
    }

    public void resetGame() {
        playerPosition = 0;
        isGameOver = false;
    }
}