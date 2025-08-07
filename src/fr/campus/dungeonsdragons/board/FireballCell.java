package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Wizard;
import fr.campus.dungeonsdragons.equipment.offensive.Spell;
import fr.campus.dungeonsdragons.equipment.offensive.Fireball;

public class FireballCell extends Cell {

    public FireballCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Fireball";
    }

    @Override
    public String toString() {
        return "You find a fireball: Strength +7";
    }

    @Override
    public void interact (Character character) {
        if (character instanceof Wizard) {
            Spell fireball = new Fireball();
            character.setOffensiveEquipment(fireball);
            character.setStrength(character.getStrength() + fireball.getAttackBoost());
            System.out.println("You pick a fireball. Strength increased by " + fireball.getAttackBoost());
        } else {
            System.out.println("You find a fireball, but can't use it.");
        }
    }
}