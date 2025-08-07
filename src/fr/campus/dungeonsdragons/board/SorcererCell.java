package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.enemy.Enemy;
import fr.campus.dungeonsdragons.enemy.Sorcerer;

public class SorcererCell extends Cell {
    private final Enemy sorcerer = new Sorcerer("Sorcerer", 2, 9);

    public SorcererCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Sorcerer";
    }

    @Override
    public String toString() {
        return "You encounter a sorcerer!";
    }

    @Override
    public void interact (Character character) {
        System.out.println("You encounter a sorcerer! FIGHT STARTING: " + character.getName() + " (" + character.getLifePoints() + " life points) attacks Sorcerer ("
                + sorcerer.getLifePoints() + " life points) with " + character.getStrength() + " strength points.");
        sorcerer.setLifePoints(sorcerer.getLifePoints() - character.getStrength());
        if (sorcerer.getLifePoints() <= 0) {
            System.out.println("Sorcerer defeated!");
        } else {
            System.out.println("The sorcerer has now " + sorcerer.getLifePoints() + " life points. He hits you with " + sorcerer.getStrength() + " strength points.");
            character.setLifePoints(character.getLifePoints() - sorcerer.getStrength());
            if (character.getLifePoints() <= 0) {
                System.out.println("You're defeated! GAME OVER!");
                // ajouter fin du jeu
            } else {
                System.out.println("You now have " + character.getLifePoints() + " life points.");
            }
        }
    }
}
