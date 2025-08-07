package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.enemy.Enemy;
import fr.campus.dungeonsdragons.enemy.Goblin;

public class GoblinCell extends Cell {
    private final Enemy goblin = new Goblin("Goblin", 1, 6);

    public GoblinCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Goblin";
    }

    @Override
    public String toString() {
        return "You encounter a goblin!";
    }

    @Override
    public void interact (Character character) {
        System.out.println("You encounter a goblin! FIGHT STARTING: " + character.getName() + " (" + character.getLifePoints() + " life points) attacks Goblin ("
                + goblin.getLifePoints() + " life points) with " + character.getStrength() + " strength points.");
        goblin.setLifePoints(goblin.getLifePoints() - character.getStrength());
        if (goblin.getLifePoints() <= 0) {
            System.out.println("Goblin defeated!");
        } else {
            System.out.println("The goblin has now " + goblin.getLifePoints() + " life points. He hits you with " + goblin.getStrength() + " strength points.");
            character.setLifePoints(character.getLifePoints() - goblin.getStrength());
            if (character.getLifePoints() <= 0) {
                System.out.println("You're defeated! GAME OVER!");
                // ajouter fin du jeu
            } else {
                System.out.println("You now have " + character.getLifePoints() + " life points.");
            }
        }
    }
}
