package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;

public class Warrior extends Character {
    public Warrior (int id, String name, int strength, int lifePoints, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(String.valueOf(id),name,strength,lifePoints,offensiveEquipment,defensiveEquipment);
    }

    @Override
    public String getType() {
        return "Warrior";
    }
}
