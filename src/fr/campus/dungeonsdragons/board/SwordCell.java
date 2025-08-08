package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Warrior;
import fr.campus.dungeonsdragons.equipment.offensive.Weapon;
import fr.campus.dungeonsdragons.equipment.offensive.Sword;

public class SwordCell extends Cell {

    public SwordCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Sword";
    }

    @Override
    public String toString() {
        return "You find a sword!";
    }

    @Override
    public void interact (Character character) {
        if (character instanceof Warrior) {
            Weapon sword = new Sword();
            character.setOffensiveEquipment(sword);
            character.setStrength(character.getStrength() + sword.getAttackBoost());
            System.out.println("Strength +" + sword.getAttackBoost());
        } else {
            System.out.println("Unfortunately, you can't use it.");
        }
    }
}
