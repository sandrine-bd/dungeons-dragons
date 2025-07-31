package fr.campus.dungeonsdragons.equipment.offensive;

public class Weapon extends OffensiveEquipment {
    public Weapon(int attack, String name) {
        super(attackBoost, name);
    }

    @Override
    public String getType() {
        return "Weapon";
    }
}
