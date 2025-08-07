package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Wizard;
import fr.campus.dungeonsdragons.equipment.offensive.Spell;
import fr.campus.dungeonsdragons.equipment.offensive.Lightning;

public class LightningCell extends Cell {

    public LightningCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Lightning";
    }

    @Override
    public String toString() {
        return "You find a lightning: Strength +2";
    }

    @Override
    public void interact (Character character) {
        if (character instanceof Wizard) {
            Spell lightning = new Lightning();
            character.setOffensiveEquipment(lightning);
            character.setStrength(character.getStrength() + lightning.getAttackBoost());
            System.out.println("You pick a lightning. Strength increased by " + lightning.getAttackBoost());
        } else {
            System.out.println("You find a lightning, but can't use it.");
        }
    }
}