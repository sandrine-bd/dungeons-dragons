package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.enemy.Enemy;
import fr.campus.dungeonsdragons.enemy.Dragon;

public class DragonCell extends Cell {
    private final Enemy dragon = new Dragon("Dragon", 4, 15);

    public DragonCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Dragon";
    }

    @Override
    public String toString() {
        return "You encounter a Dragon!";
    }

    @Override
    public void interact (Character character) {
        System.out.println("FIGHT STARTING: " + character.getName() + " (" + character.getLifePoints() + " life points) attacks Dragon ("
                + dragon.getLifePoints() + " life points) with " + character.getStrength() + " strength points.");
        dragon.setLifePoints(dragon.getLifePoints() - character.getStrength());
        if (dragon.getLifePoints() <= 0) {
            System.out.println("Dragon defeated!");
        } else {
            System.out.println("The Dragon has now " + dragon.getLifePoints() + " life points. He hits you with " + dragon.getStrength() + " strength points.");
            character.setLifePoints(character.getLifePoints() - dragon.getStrength());
            if (character.getLifePoints() <= 0) {
                System.out.println("You're defeated!");
                // ajouter fin du jeu
            } else {
                System.out.println("You now have " + character.getLifePoints() + " life points.");
            }
        }
    }
}
