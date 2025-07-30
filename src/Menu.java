import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu (Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. New character");
        System.out.println("2. Quit game");
    }

    public int getUserChoice() {
        System.out.println("Your choice: ");
        return scanner.nextInt();
    }

    public Character createCharacter() {
        scanner.nextLine();
        System.out.println("Choose type (Warrior / Wizard): ");
        String type = scanner.nextLine();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        int health;
        int attack;
        OffensiveEquipment offensiveEquipment;

        if (type.equalsIgnoreCase("Warrior")) {
            health = getRandomValue(5, 10);
            attack = getRandomValue(5, 10);
            offensiveEquipment = new OffensiveEquipment("Weapon", 3, "Club");
        }
        else {
            health = getRandomValue(3, 6);
            attack = getRandomValue(8, 15);
            offensiveEquipment = new OffensiveEquipment("Spell", 2, "Spark");
        }
        return new Character(type, name, health, attack, offensiveEquipment);
    }

    public void displayCharacterMenu(Character character) {
        System.out.println("CHARACTER MENU");
        System.out.println("1. Show character info");
        System.out.println("2. Edit name");
        System.out.println("3. Start the game");
    }

    public void showCharacter(Character character) {
        System.out.println(character.toString());
    }

    public void editCharacterName(Character character) {
        scanner.nextLine();
        System.out.println("New name: ");
        String newName = scanner.nextLine();
        character.setName(newName);
        System.out.println("Name updated");
    }

    private int getRandomValue(int min, int max) {
        return min + (int)(Math.random() * ((max-min) + 1));
    }
}
