package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;

public class Wizard extends Character {
    public Wizard (int id, String name, int strength, int lifePoints, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(String.valueOf(id),name,strength,lifePoints,offensiveEquipment,defensiveEquipment);
    }

    @Override
    public String getType() {
        return "Wizard";
    }
}
