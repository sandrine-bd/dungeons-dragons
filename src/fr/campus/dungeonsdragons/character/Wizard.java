package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;

public class Wizard extends Character {
    public Wizard (String name, int health, int attack, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(name,health,attack,offensiveEquipment,defensiveEquipment);
    }

    @Override
    public String getType() {
        return "Wizard";
    }
}
