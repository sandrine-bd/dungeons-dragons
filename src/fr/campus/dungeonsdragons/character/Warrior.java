package fr.campus.dungeonsdragons.character;

import fr.campus.dungeonsdragons.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeonsdragons.equipment.offensive.OffensiveEquipment;

public class Warrior extends Character {
    public Warrior (int id, String name, int health, int attack, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(id,name,health,attack,offensiveEquipment,defensiveEquipment);
    }

    @Override
    public String getType() {
        return "Warrior";
    }
}
