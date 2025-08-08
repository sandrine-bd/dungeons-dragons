package fr.campus.dungeonsdragons.main;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Warrior;
import fr.campus.dungeonsdragons.character.Wizard;
import fr.campus.dungeonsdragons.equipment.offensive.*;
import fr.campus.dungeonsdragons.equipment.defensive.*;
import fr.campus.dungeonsdragons.db.CharacterDAO;
import fr.campus.dungeonsdragons.db.ConnexionMySQL;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Random;

public class Menu {
    private final Scanner scanner;
    private final CharacterDAO characterDAO;

    public Menu (Scanner scanner) {
        this.scanner = scanner;
        this.characterDAO = new ConnexionMySQL().getCharacterDAO();
    }

    public Character createCharacter() {
        System.out.println("\n--- CREATE CHARACTER ---");

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
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Name cannot be empty.");
            }
        }

        int strength, lifePoints;
        Random random = new Random();
        DefensiveEquipment defensiveEquipment = random.nextBoolean() ? new SmallPotion() : new BigPotion();
        OffensiveEquipment offensiveEquipment;
        Character character;

        if (type.equalsIgnoreCase("Warrior")) {
            strength = getRandomValue(5, 10);
            lifePoints = getRandomValue(5, 10);
            offensiveEquipment = random.nextBoolean() ? new Club() : new Sword();
            character = new Warrior(0, name, strength, lifePoints, offensiveEquipment, defensiveEquipment);
        } else {
            strength = getRandomValue(8, 15);
            lifePoints = getRandomValue(3, 6);
            offensiveEquipment = random.nextBoolean() ? new Lightning() : new Fireball();
            character = new Wizard(0, name, strength, lifePoints, offensiveEquipment, defensiveEquipment);
        }

        // sauvegarde dans la BDD
        int generatedId = 0;
        try {
            generatedId = characterDAO.add(character);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        character.setId(generatedId);

        System.out.println("Character saved with ID: " + generatedId);
        return character;
    }

    public void displayMenu(Character character) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Show character info");
            System.out.println("2. Edit name");
            System.out.println("3. Continue playing");
            System.out.println("4. Quit game");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> showCharacter(character);
                case "2" -> editCharacterName(character);
                case "3" -> {
                    return; // continue dans Main
                }
                case "4" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void showCharacter(Character character) {
        System.out.println("\n--- CHARACTER INFO ---");
        System.out.println(character.toString());
    }

    public void editCharacterName(Character character) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            character.setName(newName);
            try {
                characterDAO.update(character); // mise à jour en BDD
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Name updated successfully!");
        } else {
            System.out.println("Name cannot be empty.");
        }
    }

    private int getRandomValue(int min, int max) {
        return min + (int)(Math.random() * ((max-min) + 1));
    }
}
