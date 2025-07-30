import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Menu menu;
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
                    handleCharacterSetup();
                    play();
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

    private void handleCharacterSetup() {
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
                    editing = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void play() {
        System.out.println("Game starts! You're on cell 1/64.");
        position = 1;

        while (position < 64) {
            System.out.println("\nPress ENTER to roll the dice");
            scanner.nextLine();
            int roll = rollDice();
            System.out.println("You rolled: " + roll);
            position += roll;
            if (position> 64) {
                position = 64;
            }
            System.out.println("Current position + " + position + "/64");
        }

        System.out.println("Congratulations! You've reached the end!");
        System.out.println("Play again? (yes/no): ");
        String again = scanner.nextLine();
        if (again.equalsIgnoreCase("yes")) {
            launch();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    private int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }
}
