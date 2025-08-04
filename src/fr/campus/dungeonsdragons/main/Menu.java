package fr.campus.dungeonsdragons.main;

import java.util.Scanner;
import java.util.Random;
import java.util.List;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Warrior;
import fr.campus.dungeonsdragons.character.Wizard;
import fr.campus.dungeonsdragons.equipment.offensive.*;
import fr.campus.dungeonsdragons.equipment.defensive.*;
import fr.campus.dungeonsdragons.db.CharacterDAO;
import fr.campus.dungeonsdragons.db.ConnexionMySQL;

public class Menu {
    private final Scanner scanner;
    private final CharacterDAO characterDAO;

    public Menu (Scanner scanner) {
        this.scanner = scanner;
        this.characterDAO = new ConnexionMySQL().getCharacterDAO();
    }

    public void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. New character");
        System.out.println("2. Quit game");
    }

    public int getUserChoice() {
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consomme le \n qui reste après nextInt()
        return choice;
    }

    public Character createCharacter() {
        String type;
        while (true) {
            System.out.print("Choose type (Warrior / Wizard): ");
            type = scanner.nextLine().trim(); // enlève les espaces dans le mot
            if (type.equalsIgnoreCase("Warrior") || type.equalsIgnoreCase("Wizard")) {
                break;
            } else {
                System.out.println("Invalid type. Please enter 'Warrior' or 'Wizard'.");
            }
        }

        String name;
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Name cannot be empty.");
            }
        }

        int health;
        int attack;
        Random random = new Random();
        DefensiveEquipment defensiveEquipment;
        OffensiveEquipment offensiveEquipment;

        if (random.nextBoolean()) {
            defensiveEquipment = new SmallPotion();
        } else {
            defensiveEquipment = new BigPotion();
        }

        if (type.equalsIgnoreCase("Warrior")) {
            health = getRandomValue(5, 10);
            attack = getRandomValue(5, 10);
            offensiveEquipment = random.nextBoolean() ? new Club() : new Sword();
            return new Warrior(id, name, attack, health, offensiveEquipment, defensiveEquipment);
        } else {
            health = getRandomValue(3, 6);
            attack = getRandomValue(8, 15);
            offensiveEquipment = random.nextBoolean() ? new Lightning() : new Fireball();
            return new Wizard(id, name, attack, health, offensiveEquipment, defensiveEquipment);
        }
    }

    /**
     *
     * @param character
     */
    public void displayCharacterMenu(Character character) {
        System.out.println("CHARACTER MENU");
        System.out.println("1. Show character info");
        System.out.println("2. Edit name");
        System.out.println("3. Start the game");
        System.out.println("4. Quit game");
    }

    public void showCharacter(Character character) {
        System.out.println(character.toString());
    }

    public void editCharacterName(Character character) {
        String newName;
        while (true) {
            System.out.print("New name: ");
            newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                break;
            } else {
                System.out.println("Name cannot be empty.");
            }
        }
        character.setName(newName);
        System.out.println("Name updated");
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    private int getRandomValue(int min, int max) {
        return min + (int)(Math.random() * ((max-min) + 1));
    }
}
