package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.board.*;
import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.exception.OutOfBoardException;

import java.util.Scanner;
import java.util.Random;

public class Game {
    private final Board board;
    private int playerPosition = 0;
    private boolean isGameOver = false;
    private final Menu menu;
    Dice dice6 = new SixSidedDice();
    Dice dice20 = new TwentySidedDice();

    public Game(Menu menu) {
        this.board = new Board();
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
                int roll = dice6.rollDice();
                System.out.println("\nYou rolled a " + roll + ".");

                try {
                    movePlayer(roll);
                } catch (OutOfBoardException e) {
                    System.out.println("You've reached the end of the board. YOU WIN!");
                    return "WON";
                }

                Cell cell = board.getCell(playerPosition);
                System.out.println(cell);

                if (cell instanceof GoblinCell || cell instanceof SorcererCell || cell instanceof DragonCell) {
                    System.out.println("1. Attack");
                    System.out.println("2. Run away");
                    System.out.print("Your choice: ");
                    String fightChoice = scanner.nextLine().trim();
                    if (fightChoice.equals("2")) {
                        int backSteps = dice6.rollDice();
                        playerPosition = Math.max(0, playerPosition - backSteps); // ne peut pas reculer en-dessous de la case 0
                        System.out.println("You run away and move back " + backSteps + " steps to position " + playerPosition + ".");
                        return "IN_PROGRESS";
                    }

                    // sinon, interaction normale
                    int attackRoll = dice20.rollDice();
                    System.out.print("You roll a d20 and get " + attackRoll + ": ");

                    int damage = character.getStrength();

                    if (attackRoll == 1) {
                        System.out.println("Critical fail! You miss your attack.");
                        damage = 0;
                    } else if (attackRoll == 20) {
                        System.out.println("Critical success! +2 damage.");
                        damage += 2;
                    } else {
                        System.out.println("no critical fail or success, normal fight can start.");
                    }
                }

                cell.interact(character);

                if (character.getLifePoints() <= 0) {
                    System.out.println(" ");
                    isGameOver = true;
                    return "LOST";
                }

                return "IN_PROGRESS";
            }

            else if (choice.equals("2")) {
                menu.displayMenu(character);

            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
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