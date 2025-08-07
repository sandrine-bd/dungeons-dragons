package fr.campus.dungeonsdragons.board;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Warrior;
import fr.campus.dungeonsdragons.equipment.offensive.Weapon;
import fr.campus.dungeonsdragons.equipment.offensive.Club;

public class ClubCell extends Cell {

    public ClubCell(int position) {
        super(position);
    }

    @Override
    public String getType() {
        return "Club";
    }

    @Override
    public String toString() {
        return "You find a club: Strength +3";
    }

    @Override
    public void interact (Character character) {
        if (character instanceof Warrior) {
            Weapon club = new Club();
            character.setOffensiveEquipment(club);
            character.setStrength(character.getStrength() + club.getAttackBoost());
            System.out.println("You pick a club. Strength increased by " + club.getAttackBoost());
        } else {
            System.out.println("You find a club, but can't use it.");
        }
    }
}
