package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;

public class Wizard extends Character {
    public Wizard (int id, String name, int health, int attack, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(id,name,health,attack,offensiveEquipment,defensiveEquipment);
    }

    @Override
    public String getType() {
        return "Wizard";
    }
}
