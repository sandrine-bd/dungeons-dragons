package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;

public class Warrior extends Character {
    public Warrior (String name, int health, int attack, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(name,health,attack,offensiveEquipment,defensiveEquipment);
    }

    @Override
    public String getType() {
        return "Warrior";
    }
}
